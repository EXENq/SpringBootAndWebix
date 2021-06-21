define(function (cars) {
    return {
        type: "line",
        height: "400",
        rows: [
            {
                view: 'button',
                label: 'Cars',
                click: function () {
                    routie('cars')
                }
            },
            { template: "View 1" },
            { template: "View 2" },
            {
                cols: [
                    { template: "col 1" },
                    { template: "col 2" },
                ]
            }
        ]
    }
});