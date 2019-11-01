/**
 *********************************************
 * Utility Javascript for FainTV-CMS
 * @data 2018.04.10
 *********************************************
**/

/*
 * Use for display loader or hide loader
 *  
 */

function utilDisplayLoader(){
	$("#util-loader-background").removeClass("d-none");
	//$("body").css("overflow","hidden");
}

function utilHideLoader(){
	$("#util-loader-background").addClass("d-none");
	//$("body").css("overflow","auto");
	
}

/*
 * Use for date time format with
 * $(Object).utilToLocalDate('Datetime pattern')
 * 
 */
(function ($) {
    $.fn.utilToLocalDate = function(pattern) {
    	var _pattern = pattern && $.type(pattern) == 'string'? pattern : 'YYYY-MM-DD HH:mm:ss';

    	$(this).each(function() {
    		var $tag = $(this);

    		if($tag[0].nodeName.toUpperCase() == 'input'.toUpperCase()) {
        		if($tag.val().trim() == '') {
        			return true; // skip to next iteration if value is empty
        		}
        		
    			var utcValue = moment.utc($tag.val()).format();
    			$tag.val(moment(utcValue).format(_pattern));
    		} else {
        		if($tag.text().trim() == '') {
        			return true; // skip to next iteration if text is empty
        		}
    			
    			var utcValue = moment.utc($tag.text()).format();
    			$tag.text(moment(utcValue).format(_pattern));
    		}
    		
    	});
    	
        return this;
    };
})(jQuery);

function utilConverDateTimeWithUTC(dateTime){
	dateTime = moment(dateTime).format();
	dateTime = moment.utc(dateTime).format();
	return dateTime;
}

function utilConverDateTimeWithUTC(dateTime,format){
	dateTime = moment(dateTime).format(format);
	dateTime = moment.utc(dateTime).format();
	return dateTime;
}

function utilToLocalDateVal(dateVal,pattern) {
	var _pattern = pattern && $.type(pattern) == 'string'? pattern : 'YYYY-MM-DD HH:mm:ss';
	var utcFormat = moment(dateVal).format();
	var utcValue = moment.utc(utcFormat).format();
	return moment(utcValue).format(_pattern);
}


/*
 * Use for Generate Pagination follow by bootstrap 4 and base on pageBean
 * 
 * maxLen : max page item in the page.
 * method : trigger it when user click page item.
 * 
 */

(function($) {
    $.fn.extend({
    	generatePageBean: function(pageBean, maxLen, countText , method) {
        	$(this).html("");
        	$(this).parent("nav").children("p").remove();
			var front = Math.round((1 + maxLen) / 2)-1 ;
            var end = maxLen - front - 1;
            
            var startIndex = 1;
        	var endIndex = maxLen;
            
            if(pageBean.pageCount > maxLen){
                if(pageBean.pageNo - front > 0){
                    startIndex = pageBean.pageNo - front;
                }
            
                if(startIndex + (maxLen-1) > pageBean.pageCount){
                    startIndex = pageBean.pageCount - (maxLen-1);
                }
            
                if(endIndex - startIndex < (maxLen-1)){
                    endIndex = startIndex + (maxLen-1);
                }
            }else{
                endIndex = pageBean.pageCount;
            }
            
            $(this).parent("nav").append("<p class='mb-1 text-center'>"+countText+"</p>")
            
            var preHtml = "<li class='page-item li-prepage' data-page='"+pageBean.prePage+"'><a class='page-link' href='#' onclick='return;'><span aria-hidden='true'>«</span><span class='sr-only'>Previous</span></a></li>";
            if(pageBean.prePageExist){
            	$(this).append(preHtml);
            }
            for(startIndex ; startIndex <= endIndex; startIndex++ ){
        		$(this).append("<li class='page-item li-content "+ (startIndex == pageBean.pageNo ? "active" : "")  +"' data-page='"+startIndex+"'><a class='page-link' href='#' onclick='return;'>"+startIndex+"</a></li>");
        	}
                     
            var nextHtml = "<li class='page-item li-prepage' data-page='"+pageBean.nextPage+"'><a class='page-link' href='#' onclick='return;'><span aria-hidden='true'>»</span><span class='sr-only'>Next</span></a></li>";
            
            if(pageBean.nextPageExist){
            	$(this).append(nextHtml);
            }
            
            $(this).find(".page-item").click(function(){
                return method($(this).attr("data-page"));
            });
        }
    });
})(jQuery);
