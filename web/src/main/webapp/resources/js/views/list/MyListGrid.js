
EmailChimp.view('MyListGrid',
        {
            getMyListGrid: function () {
                return{
                    id: "myListGrid",
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
                            template: "{common.checkbox()}",
                            width: 50
                        },{
                            id: "contact",
                            header: "Contact",
                            minWidth: 20,
                            editor: "text"
                        }, {
                            id: "email",
                            header: "Email",
                            width: 270,
                            editor: "text"
                        }, {
                            id: "firstName",
                            header: "First Name",
                            width: 200,
                            editor: "text"
                        }, {
                            id: "lastName",
                            header: "Last Name",
                            width: 200,
                            editor: "text"
                        }, {
                            id: "emailCategory[0].id",
                            header: "Category",
                            width: 200,
                            editor: "text"
                        },
                        {
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
                    data: EmailChimp.models.MailModal.getEmailList(),
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
                            data: {title: "My List"}
                        },
                        {
                            type: "space",
                            rows: [
                                {
                                    height: 40,
                                    cols: [
                                        this.getButton('add', 'Add', 'plus-circle'),
                                        this.getButton('import', 'Import(.xls)', 'upload'),
                                        {},
                                        {
                                            view: "richselect",
                                            id: "mail_filter",
                                            value: "all",
                                            maxWidth: 300,
                                            minWidth: 250,
                                            vertical: true,
                                            labelWidth: 110,
                                            options: [
                                                {id: "all", value: "All"},
                                                {id: "1", value: "Published"},
                                                {id: "2", value: "Not published"},
                                                {id: "0", value: "Deleted"}
                                            ],
                                            label: "Filter mails"
                                        }
                                    ]
                                },
                                {
                                    rows: [
                                        this.getMyListGrid(),
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
