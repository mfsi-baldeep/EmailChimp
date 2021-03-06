
EmailChimp.view('CategoryGrid',
        {
            getCategoryGrid: function () {
                return{
                    id: "categoryGrid",
                    view: "datatable",
                    select: true,
                    editable: true,
                    editaction: "dblclick",
                    on: {
                        onBeforeEditStop: function (data, prevent) {
                            var newValue = data.value;
                            if (newValue.length === 0 || !newValue.trim())
                            {
                                webix.alert("Please make sure you enter valid details");
                                return false;
                            }
                        }
                    },
                    columns: [
                        {
                            id: "id",
                            header: "#",
                            width: 50
                        }, {
                            id: "categoryName",
                            header: "Category Name",
                            template:function htmlEncode( html ) {
                                return EmailChimp.htmlEncode(html.categoryName);
                            },
                            width: 900,
                            fillspace: 1,
                            editor: "text",
                        }, {
                            id: "delete",
                            header: "&nbsp;",
                            width: 35,
                            template: "<span  style='cursor:pointer;' class='webix_icon fa-trash-o trash'></span>"},
                        {
                            id: "save",
                            header: "&nbsp;",
                            width: 35,
                            template: "<span  style='cursor:pointer;' class='webix_icon fa-floppy-o save'></span>"}
                    ],
                    pager: "pagerA",
                    data: EmailChimp.models.MailModal.getEmailCategory(),
                    ready: function () {
                        webix.extend(this, webix.ProgressBar);
                    }
                };
            },
            getButton: function (id, text, icon) {
                return {
                    view: "button",
                    id: id,
                    type: "iconButton",
                    icon: icon,
                    width: 150,
                    label: text
                };
            },
            getlayout: function () {
                return {
                    id: 'main',
                    type: 'clean',
                    rows: [
                        {
                            height: 49,
                            id: "title",
                            css: "title",
                            template: "<div class='header'>#title#</div>",
                            data: {title: "My Category"}
                        },
                        {
                            type: "space",
                            rows: [
                                {
                                    height: 40,
                                    cols: [
                                        this.getButton('add', 'Add', 'plus-circle'),
                                        {}
                                    ]
                                },
                                {
                                    rows: [
                                        this.getCategoryGrid(),
                                        {
                                            view: "toolbar",
                                            css: "highlighted_header header6",
                                            paddingX: 5,
                                            paddingY: 5,
                                            height: 40,
                                            cols: [{
                                                    view: "pager", id: "pagerA",
                                                    template: "{common.first()}{common.prev()}&nbsp; {common.pages()}&nbsp; {common.next()}{common.last()}",
                                                    autosize: true,
                                                    height: 35,
                                                    group: 5
                                                }

                                            ]
                                        }
                                    ]
                                }


                            ]

                        }
                    ]
                };
            }
        });
