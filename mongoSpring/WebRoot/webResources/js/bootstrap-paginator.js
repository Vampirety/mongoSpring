/**
 * bootstrap-paginator.js v0.5
 * --
 * Copyright 2013 Yun Lai <lyonlai1984@gmail.com>
 * --
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

(function ($) {

    "use strict"; // jshint ;_;


    /* Paginator PUBLIC CLASS DEFINITION
     * ================================= */

    /**
     * Boostrap Paginator Constructor
     *
     * @param element element of the paginator
     * @param options the options to config the paginator
     *
     * */
    var BootstrapPaginator = function (element, options) {
        this.init(element, options);
    },
    old = null;

    var pagination=null;
    
    BootstrapPaginator.prototype = {

        /**
         * Initialization function of the paginator, accepting an element and the options as parameters
         *
         * @param element element of the paginator
         * @param options the options to config the paginator
         *
         * */
        init: function (element, options) {
            this.$element = $(element);
            var version = (options && options.bootstrapMajorVersion) ? options.bootstrapMajorVersion : $.fn.bootstrapPaginator.defaults.bootstrapMajorVersion,
                id = this.$element.attr("id");

            if (version === 2 && !this.$element.is("div")) {

                throw "in Bootstrap version 2 the pagination must be a div element. Or if you are using Bootstrap pagination 3. Please specify it in bootstrapMajorVersion in the option";
            } else if (version > 2 && !this.$element.is("ul")) {
                throw "in Bootstrap version 3 the pagination root item must be an ul element."
            }



            this.currentPage = 1;

            this.lastPage = 1;

            this.setOptions(options);

            this.initialized = true;
        },

        /**
         * Update the properties of the paginator element
         *
         * @param options options to config the paginator
         * */
        setOptions: function (options) {
            this.options = $.extend({}, (this.options || $.fn.bootstrapPaginator.defaults), options);

            this.totalPages = parseInt(this.options.totalPages, 10);  //setup the total pages property.
            this.numberOfPages = parseInt(this.options.numberOfPages, 10); //setup the numberOfPages to be shown

            //move the set current page after the setting of total pages. otherwise it will cause out of page exception.
            if (options && typeof (options.currentPage)  !== 'undefined') {

                this.setCurrentPage(options.currentPage);
            }

            this.listen();

            //render the paginator
            this.render();

            if (!this.initialized && this.lastPage !== this.currentPage) {
                this.$element.trigger("page-changed", [this.lastPage, this.currentPage]);
            }

        },

        /**
         * Sets up the events listeners. Currently the pageclicked and pagechanged events are linked if available.
         *
         * */
        listen: function () {
            this.$element.off("page-clicked");

            this.$element.off("page-changed");// unload the events for the element

            if (typeof (this.options.onPageClicked) === "function") {
                this.$element.bind("page-clicked", this.options.onPageClicked);
            }

            if (typeof (this.options.onPageChanged) === "function") {
                this.$element.on("page-changed", this.options.onPageChanged);
            }

            this.$element.bind("page-clicked", this.onPageClicked);
        },


        /**
         *
         *  Destroys the paginator element, it unload the event first, then empty the content inside.
         *
         * */
        destroy: function () {
            this.$element.off("page-clicked");

            this.$element.off("page-changed");

            this.$element.removeData('bootstrapPaginator');

            this.$element.empty();

        },

        /**
         * Shows the page
         *
         * */
        show: function (page) {
            this.setCurrentPage(page);

            this.render();

            if (this.lastPage !== this.currentPage) {
                this.$element.trigger("page-changed", [this.lastPage, this.currentPage]);
            }
        },

        /**
         * Shows the next page
         *
         * */
        showNext: function () {
            var pages = this.getPages(options);
            
            if (pagination.next) {
                this.show(pagination.next);
            }

        },

        /**
         * Shows the previous page
         *
         * */
        showPrevious: function () {
            var pages = this.getPages(options);

            if (pagination.prev) {
                this.show(pagination.prev);
            }

        },

        /**
         * Shows the first page
         *
         * */
        showFirst: function () {
            var pages = this.getPages(options);

            if (pagination.first) {
                this.show(pagination.first);
            }

        },

        /**
         * Shows the last page
         *
         * */
        showLast: function () {
            var pages = this.getPages(options);

            if (pagination.last) {
                this.show(pagination.last);
            }

        },

        /**
         * Internal on page item click handler, when the page item is clicked, change the current page to the corresponding page and
         * trigger the pageclick event for the listeners.
         *
         *
         * */
        onPageItemClicked: function (event) {
            var type = event.data.type,
                page = event.data.page;

            this.$element.trigger("page-clicked", [event, type, page]);

        },

        onPageClicked: function (event, originalEvent, type, page) {
            //show the corresponding page and retrieve the newly built item related to the page clicked before for the event return
        	
            var currentTarget = $(event.currentTarget);

            switch (type) {
            case "first":
                currentTarget.bootstrapPaginator("showFirst");
                break;
            case "prev":
                currentTarget.bootstrapPaginator("showPrevious");
                break;
            case "next":
                currentTarget.bootstrapPaginator("showNext");
                break;
            case "last":
                currentTarget.bootstrapPaginator("showLast");
                break;
            case "page":
                currentTarget.bootstrapPaginator("show", page);
                break;
            }

        },

        /**
         * Renders the paginator according to the internal properties and the settings.
         *
         *
         * */
        render: function () {
            //fetch the container class and add them to the container
            var containerClass = this.getValueFromOption(this.options.containerClass, this.$element),
                size = this.options.size || "normal",
                alignment = this.options.alignment || "left",
                
                listContainer = this.options.bootstrapMajorVersion === 2 ? $("<ul></ul>") : this.$element,
                listContainerClass = this.options.bootstrapMajorVersion === 2 ? this.getValueFromOption(this.options.listContainerClass, listContainer) : null,
                first = null,
                prev = null,
                next = null,
                last = null,
                p = null,
                i = 0;
            var ele=this;
            this.getPages(options,this.currentPage,function(data){
            	
            	//---------
            	format(data,options);
            	
    			//alert("totalPages1:"+ele.totalPages);
    			ele.numberOfPages=data.pageSize;
    			//alert("numberOfPages:"+this.numberOfPages);
    			ele.currentPage=data.pageNumber;
    			//alert("currentPage:"+this.currentPage);
    			if(data.totalCount>data.pageSize){
            		ele.totalPages=(data.totalCount/data.pageSize+1);
            	}else{
            		ele.totalPages=1;
            	}
    			var totalPages = ele.totalPages,// get or calculate the total pages via the total records
                
                pageStart = (ele.currentPage % ele.numberOfPages === 0) ? (parseInt(ele.currentPage / ele.numberOfPages, 10) - 1) * ele.numberOfPages + 1 : parseInt(ele.currentPage / ele.numberOfPages, 10) * ele.numberOfPages + 1,//calculates the start page.
                output = [],
                i = 0,
                counter = 0;

                pageStart = pageStart < 1 ? 1 : pageStart;//check the range of the page start to see if its less than 1.

                for (i = pageStart, counter = 0; counter < ele.numberOfPages && i <= totalPages; i = i + 1, counter = counter + 1) {//fill the pages
                    output.push(i);
                }

                output.first = 1;//add the first when the current page leaves the 1st page.

                if (ele.currentPage > 1) {// add the previous when the current page leaves the 1st page
                    output.prev = ele.currentPage - 1;
                } else {
                    output.prev = 1;
                }

                if (ele.currentPage < totalPages) {// add the next page when the current page doesn't reach the last page
                    output.next = ele.currentPage + 1;
                } else {
                    output.next = totalPages;
                }

                output.last = totalPages;// add the last page when the current page doesn't reach the last page

                output.current = ele.currentPage;//mark the current page.

                output.total = totalPages;

                output.numberOfPages = ele.numberOfPages;
                //-----------------
            	
            	ele.$element.prop("class", "");

            	ele.$element.addClass("pagination");

                switch (size.toLowerCase()) {
                case "large":
                case "small":
                case "mini":
                	ele.$element.addClass($.fn.bootstrapPaginator.sizeArray[ele.options.bootstrapMajorVersion][size.toLowerCase()]);
                    break;
                default:
                    break;
                }

                if (ele.options.bootstrapMajorVersion === 2) {
                    switch (alignment.toLowerCase()) {
                    case "center":
                        ele.$element.addClass("pagination-centered");
                        break;
                    case "right":
                        ele.$element.addClass("pagination-right");
                        break;
                    default:
                        break;
                    }
                }


                ele.$element.addClass(containerClass);

                //empty the outter most container then add the listContainer inside.
                ele.$element.empty();

                if (ele.options.bootstrapMajorVersion === 2) {
                    ele.$element.append(listContainer);

                    listContainer.addClass(listContainerClass);
                }

                //update the page element reference
                ele.pageRef = [];

                if (output.first) {//if the there is first page element
                    first = ele.buildPageItem("first", output.first);

                    if (first) {
                        listContainer.append(first);
                    }

                }

                if (output.prev) {//if the there is previous page element

                    prev = ele.buildPageItem("prev", output.prev);

                    if (prev) {
                        listContainer.append(prev);
                    }

                }


                for (i = 0; i < output.length; i = i + 1) {//fill the numeric pages.

                    p = ele.buildPageItem("page", output[i]);

                    if (p) {
                        listContainer.append(p);
                    }
                }

                if (output.next) {//if there is next page

                    next = ele.buildPageItem("next", output.next);

                    if (next) {
                        listContainer.append(next);
                    }
                }

                if (output.last) {//if there is last page

                    last = ele.buildPageItem("last", output.last);

                    if (last) {
                        listContainer.append(last);
                    }
                }
                pagination=output;
            });
        },

        /**
         *
         * Creates a page item base on the type and page number given.
         *
         * @param page page number
         * @param type type of the page, whether it is the first, prev, page, next, last
         *
         * @return Object the constructed page element
         * */
        buildPageItem: function (type, page) {
            var itemContainer = $("<li></li>"),//creates the item container
                itemContent = $("<a></a>"),//creates the item content
                text = "",
                title = "",
                itemContainerClass = this.options.itemContainerClass(type, page, this.currentPage),
                itemContentClass = this.getValueFromOption(this.options.itemContentClass, type, page, this.currentPage),
                tooltipOpts = null;


            switch (type) {

            case "first":
                if (!this.getValueFromOption(this.options.shouldShowPage, type, page, this.currentPage)) { return; }
                text = this.options.itemTexts(type, page, this.currentPage);
                title = this.options.tooltipTitles(type, page, this.currentPage);
                break;
            case "last":
                if (!this.getValueFromOption(this.options.shouldShowPage, type, page, this.currentPage)) { return; }
                text = this.options.itemTexts(type, page, this.currentPage);
                title = this.options.tooltipTitles(type, page, this.currentPage);
                break;
            case "prev":
                if (!this.getValueFromOption(this.options.shouldShowPage, type, page, this.currentPage)) { return; }
                text = this.options.itemTexts(type, page, this.currentPage);
                title = this.options.tooltipTitles(type, page, this.currentPage);
                break;
            case "next":
                if (!this.getValueFromOption(this.options.shouldShowPage, type, page, this.currentPage)) { return; }
                text = this.options.itemTexts(type, page, this.currentPage);
                title = this.options.tooltipTitles(type, page, this.currentPage);
                break;
            case "page":
                if (!this.getValueFromOption(this.options.shouldShowPage, type, page, this.currentPage)) { return; }
                text = this.options.itemTexts(type, page, this.currentPage);
                title = this.options.tooltipTitles(type, page, this.currentPage);
                break;
            }

            itemContainer.addClass(itemContainerClass).append(itemContent);

            itemContent.addClass(itemContentClass).html(text).on("click", null, {type: type, page: page}, $.proxy(this.onPageItemClicked, this));

            if (this.options.pageUrl) {
                itemContent.attr("href", this.getValueFromOption(this.options.pageUrl, type, page, this.currentPage));
            }

            if (this.options.useBootstrapTooltip) {
                tooltipOpts = $.extend({}, this.options.bootstrapTooltipOptions, {title: title});

                itemContent.tooltip(tooltipOpts);
            } else {
                itemContent.attr("title", title);
            }

            return itemContainer;

        },

        setCurrentPage: function (page) {
            if (page > this.totalPages || page < 1) {// if the current page is out of range, throw exception.

                throw "Page out of range";

            }

            this.lastPage = this.currentPage;

            this.currentPage = parseInt(page, 10);

        },

        /**
         * Gets an array that represents the current status of the page object. Numeric pages can be access via array mode. length attributes describes how many numeric pages are there. First, previous, next and last page can be accessed via attributes first, prev, next and last. Current attribute marks the current page within the pages.
         *
         * @return object output objects that has first, prev, next, last and also the number of pages in between.
         * */
        getPages: function (options,page,callback) {
        	$.ajax({
        		url:options.url+"?page="+page,
        		data:options.queryParams,
        		dataType:'json',
        		type:'post',
        		timeout : 5000, //超时时间设置，单位毫秒
        		success:function(data){
	                callback && callback(data);
        		},
        		error:function(data){
        			console.info(data);
        		},
        		complete : function(XMLHttpRequest,status){
        			if(status=='timeout'){//超时,status还有success,error等值的情况
        				
        			}
        		}
        	});
        	
        },
        
        /**
         * Gets the value from the options, this is made to handle the situation where value is the return value of a function.
         *
         * @return mixed value that depends on the type of parameters, if the given parameter is a function, then the evaluated result is returned. Otherwise the parameter itself will get returned.
         * */
        getValueFromOption: function (value) {
            var output = null,
                args = Array.prototype.slice.call(arguments, 1);

            if (typeof value === 'function') {
                output = value.apply(this, args);
            } else {
                output = value;
            }

            return output;

        },
        
    };
    
    function format(data,options){
    	$("#row-fluid").remove();
    	var title='<div class="row-fluid" style="min-height:485px" id="row-fluid"><table class="table table-hover">';
    	var tbody="<tbody>";
    	var totalWidth=0;
    	$.each(options.columns,function(i,n){
    		if(n.width){
    			totalWidth+=n.width;
    		}
    	});
    	var thead="<thead><tr>";
    	var columns=[];
    	$.each(options.columns,function(i,n){
    		if(n.checkbox){
    			columns.push("checkbox");
    		}else{
    			columns.push(n.field);
    		}
    		if(n.width){
    			thead+='<th class="span'+parseInt(10*(n.width/totalWidth))+'">';
    		}else{
    			thead+='<th class="span1">';
    		}
    		if(n.checkbox){
    			thead+='<input type="checkbox" id="checkbox" onclick="selectAll();"/>';
    		}
    		if(n.title){
    			thead+=n.title+'</th>';
    		}else{
    			thead+='</th>';
    		}
    	});
    	thead+='</tr></thead>';
    	$.each(data.list,function(i,n){
    		if(i==0){
    			tbody+='<tr class="first">';
    		}else{
    			tbody+='<tr>';
    		}
    		$.each(columns,function(j,k){
    			if(options.columns[j].formatter){
    				var str=options.columns[j].formatter(n);
    				tbody+='<td class="description">'+str+'</td>';
    			}else{
    				if(k=="checkbox"){
        				tbody+='<td><input type="checkbox" value="'+n.id+'" name="checkbox"/></td>';
        			}
        			var flag=true;
        			for(var key in n){
        				if(key==k){
    						tbody+='<td class="description">'+n[key]+'</td>';
        					flag=false;
        				}
            		}
        			if(flag&&k!="checkbox"){
        				tbody+='<td class="description">null</td>';
        			}
    			}
			});
    		tbody+='</tr>';
    	});
    	tbody+='</tbody>';
    	$("#pagination").before(title+thead+tbody+"</table></div>");
    }
    
    /* TYPEAHEAD PLUGIN DEFINITION
     * =========================== */

    old = $.fn.bootstrapPaginator;

    $.fn.bootstrapPaginator = function (option) {

        var args = arguments,
            result = null;

        $(this).each(function (index, item) {
            var $this = $(item),
                data = $this.data('bootstrapPaginator'),
                options = (typeof option !== 'object') ? null : option;

            if (!data) {
                data = new BootstrapPaginator(this, options);

                $this = $(data.$element);

                $this.data('bootstrapPaginator', data);

                return;
            }

            if (typeof option === 'string') {

                if (data[option]) {
                    result = data[option].apply(data, Array.prototype.slice.call(args, 1));
                } else {
                    throw "Method " + option + " does not exist";
                }

            } else {
                result = data.setOptions(option);
            }
        });

        return result;

    };

    $.fn.bootstrapPaginator.sizeArray = {

        "2": {
            "large": "pagination-large",
            "small": "pagination-small",
            "mini": "pagination-mini"
        },
        "3": {
            "large": "pagination-lg",
            "small": "pagination-sm",
            "mini": ""
        }

    };

    $.fn.bootstrapPaginator.defaults = {
        containerClass: "",
        size: "normal",
        alignment: "left",
        bootstrapMajorVersion: 2,
        listContainerClass: "",
        itemContainerClass: function (type, page, current) {
            return (page === current) ? "active" : "";
        },
        itemContentClass: function (type, page, current) {
            return "";
        },
        currentPage: 1,
        numberOfPages: 5,
        totalPages: 1,
        pageUrl: function (type, page, current) {
            return null;
        },
        onPageClicked: null,
        onPageChanged: null,
        useBootstrapTooltip: false,
        shouldShowPage: function (type, page, current) {

            var result = true;

            switch (type) {
            case "first":
                result = (current !== 1);
                break;
            case "prev":
                result = (current !== 1);
                break;
            case "next":
                result = (current !== this.totalPages);
                break;
            case "last":
                result = (current !== this.totalPages);
                break;
            case "page":
                result = true;
                break;
            }

            return result;

        },
        itemTexts: function (type, page, current) {
            switch (type) {
            case "first":
                return "&lt;&lt;";
            case "prev":
                return "&lt;";
            case "next":
                return "&gt;";
            case "last":
                return "&gt;&gt;";
            case "page":
                return page;
            }
        },
        tooltipTitles: function (type, page, current) {

            switch (type) {
            case "first":
                return "Go to first page";
            case "prev":
                return "Go to previous page";
            case "next":
                return "Go to next page";
            case "last":
                return "Go to last page";
            case "page":
                return (page === current) ? "Current page is " + page : "Go to page " + page;
            }
        },
        bootstrapTooltipOptions: {
            animation: true,
            html: true,
            placement: 'top',
            selector: false,
            title: "",
            container: false
        }
    };

    $.fn.bootstrapPaginator.Constructor = BootstrapPaginator;
    
}(window.jQuery));

function selectAll(){
	if($("#checkbox").prop("checked")){
		$("input[name='checkbox']").prop("checked",true);
	}else{
		$("input[name='checkbox']").prop("checked",false);
	}
}

function getSelected(){
	var ids="";
	$.each($("input[name='checkbox']"),function(i,n){
		if(n.value&&$(n).prop("checked")){
			ids+=n.value+",";
		}
	});
	return ids;
}
