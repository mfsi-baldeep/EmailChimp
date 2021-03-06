/* global webix */
EmailChimp.component('SideMenuIcon', {
    init: function () {

        webix.type(webix.ui.tree, {
            name: "sideMenu",
            height: 40,
            icon: function (obj, common) {
                var html = "";
                var open = "";
                for (var i = 1; i <= obj.$level; i++) {
                    if (i === obj.$level && obj.$count) {
                        var dir = obj.open ? "down" : "right";
                        html += "<span class='" + open + " webix_icon fa-angle-" + dir + "'></span>";
                    }
                }
                return html;
            },
            folder: function (obj, common) {
                if (obj.icon)
                    return "<span class='webix_icon icon fa-" + obj.icon + "'></span>";
                return "";
            }
        });
    }
});