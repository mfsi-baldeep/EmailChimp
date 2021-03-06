EmailChimp.model('MailModal',
        {
            getAll: function () {
                var number = 150;
                var data = [];
                var code = 201;
                for (var i = 0; i < number; i++) {
                    var status = Math.floor(Math.random() * 4);
                    var price = Math.floor(Math.random() * (1500 - 499)) + 499;
                    var quantity = Math.floor(Math.random() * (400 - 3)) + 3;
                    var inStore = Math.floor(Math.random() * 9);
                    var category = (price > 1100 ? 1 : (price > 800 ? 2 : 3));
                    data.push({
                        id: i + 1,
                        code: "WBX" + code,
                        name: "Test product " + (i + 1),
                        category: category,
                        categoryName: (category == 1 ? "Wood furniture" : (category == 2 ? "Home furniture" : "Office furniture")),
                        price: price,
                        statusName: (status > 1 ? "Published" : (status == 1 ? "Not published" : "Deleted")),
                        status: (status > 1 ? "1" : (status == 1 ? "2" : "0")),
                        quantity: quantity,
                        in_stock: (inStore > 1),
                        sentdate: new Date()
                    });
                    code++;
                }
                return data;
            },
            getEmailConfiguration: function () {
              return webix.ajax().get("get-email-configuration");
            },
            getEmailCategory: function () {
              return webix.ajax().get("get-email-category");
            },
            getApi: function () {
              return webix.ajax().get("get-api");
            },
            getEmailList: function () {
              return webix.ajax().get("get-email-list");
            },
            getEmailTemplates: function () {
              return webix.ajax().get("get-email-templates");
            },
            deleteEmailTemplates: function() {
                
            },
            getCampaign: function() {
              return webix.ajax().get("get-campaign");
            },
            getEmailTracks: function() {
              return webix.ajax().get("get-email-tracks");
            },
            getSchedule: function() {
                return webix.ajax().get("get-scheduler");
            }

        });