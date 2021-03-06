EmailChimp.view('AddSettings',
        {
            getLayout: function () {
                return {
                    view: "form",
                    borderless: true,
                    id: "addSettings",
                    elements: [
                        {
                            view: "text",
                            label: 'SMTP HOST :',
                            name: "smtpHost",
                            required: true
                        }, {
                            view: "text",
                            label: 'SMTP PORT :',
                            name: "smtpPort",
                            required: true
                        }, {
                            view: "text",
                            label: 'USERNAME :',
                            name: "smtpUsername",
                            required: true
                        }, {
                            view: "text",
                            label: 'PASSWORD :',
                            name: "smtpPassword",
                            required: true
                        },
                        {view: "label", height: 50, hidden: true, id: 'responseMessage', label: '<span style=color:red><c:out value="${messageDefault}"/></span>', align: "center"},
                        {
                            view: "button",
                            value: "Add",
                            click: function () {
                                if ($$('addSettings').validate()) { //validate form

                                    webix.ajax().post("add-email-configuration", $$('addSettings').getValues(), function (text, xml, xhr) {
                                        var color = 'red';
                                        if (xhr.status === 200) {
                                            color = 'green';
                                        }
                                        var grid = $$("emailSettingsGrid");
                                        grid.clearAll();
                                        grid.showProgress();
                                        $$("win2").close();
                                        webix.delay(function () {
                                            grid.parse(EmailChimp.models.MailModal.getEmailConfiguration());
                                            grid.hideProgress();
                                        }, null, null, 50);
                                        $$('addSettings').clear();
                                        $$("responseMessage").show();
                                        $$("responseMessage").define({label: "<span style=\"color:" + color + "\">" + text + "</span>", css: "lines"});
                                        $$('responseMessage').refresh();
                                    });

                                }
                            }
                        }
                    ],
                    elementsConfig: {
                        labelPosition: "top"
                    }
                };
            }
        });