EmailChimp.controller('EmailConfigurationController',
        {
            component: ['views/preferences/EmailSettingsGrid', 'views/preferences/AddSettings', 'models/MailModal'],
            init: function () {
                controller = this;
                emailSettingsGrid = EmailChimp.views.EmailSettingsGrid;
                addSettingsForm = EmailChimp.views.AddSettings;

                // Change main layout
                $$("content").removeView('main');
                $$("content").addView(emailSettingsGrid.getlayout(), 1);
                $$("mainLayout").resize();
                this.bindEvents();
            },
            bindEvents: function () {
                //Event on css
                $$("emailSettingsGrid").on_click.trash = this.deleteSettings;
                $$("emailSettingsGrid").on_click.save = this.saveSettings;

                //Event on properties
                $$("add").define({click: this.addSettings});
            },
            deleteSettings: function (e, id, node) {
                webix.confirm({
                    text: "The configuration will be deleted. <br/> Are you sure?",
                    ok: "Yes",
                    cancel: "Cancel",
                    callback: function (res) {
                        if (res) {
                            var item = webix.$$("emailSettingsGrid").getItem(id);
                            item = item.id;
                            webix.ajax().post("delete-email-configuration", "id=" + item, function (text, xml, xhr) {
                                webix.alert(text);
                            }),
                                    $$("emailSettingsGrid").remove(id);
                        }
                    }
                });
            },
            saveSettings: function (e, id, node) {
                var item = webix.$$("emailSettingsGrid").getItem(id);
                console.log($$("emailSettingsGrid").validateEditor() + item.smtpPort.length);
                debugger;
                if (item.smtpPort.length > 1 && item.smtpHost.length > 1 && item.smtpUsername.length > 1 && item.smtpPassword.length > 1) {
                    console.log(item.smtpPort.length +":::"+ item.smtpHost.length +":::"+ item.smtpUsername.length +"::"+item.smtpPassword.length);
                    webix.confirm({
                        text: "The configuration will be saved. <br/> Are you sure?",
                        ok: "Yes",
                        cancel: "Cancel",
                        callback: function (res) {
                            if (res) {

                                webix.ajax().post("update-email-configuration", item, function (text, xml, xhr) {
                                    webix.alert(text);
                                });
                            }
                        }
                    });
                }
            },
            addSettings: function () {
                webix.ui({
                    view: "window",
                    id: "win2",
                    width: 500,
                    height: 600,
                    position: "center",
                    modal: true,
                    head: 'Add New Configuration <span style="float: right; font-size: 25px;padding: 10px;" \n\
                    class="webix_icon fa-times-circle closepopup"></span>',
                    body: addSettingsForm.getLayout()
                }).show();
            }
        }
);
