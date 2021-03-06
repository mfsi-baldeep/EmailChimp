changeData();
EmailChimp.view('SentGrid',
        {
            getSentMailGrid: function () {
                return{
                    id: "sentMailGrid",
                    view: "datatable",
                    select: true,
                    editable: false,
                    columns: [
                        {
                            id: "id",
                            header: "id",
                            width: 50
                        }, {
                            id: "recepients",
                            header: "To",
                            minWidth: 80
                        }, {
                            id: "subject",
                            header: "Subject",
                            minWidth: 120,
                            fillspace: 2,
                            editor: "text"
                        }, {
                            id: "status",
                            header: ["Status"],
                            minWidth: 75,
                            sort: "string",
                            template: "<span class='status status#statusNo#'>#status#</span>"
                        }
                    ],
                    pager: "pagerA",
                    data: data,
                    ready: function () {
                        webix.extend(this, webix.ProgressBar);
                    }
                }
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
                            data: {title: "Sent Mails"}
                        },
                        {
                            type: "space",
                            rows: [
                                {
                                    height: 40,
                                    cols: [
                                        this.getButton('compose', 'Compose', 'envelope'),
                                        this.getButton('refresh', 'Refresh', 'refresh'),
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
                                        this.getSentMailGrid(),
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
                }
            }
        });