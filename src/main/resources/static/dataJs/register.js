let vm = new Vue({
    el: '#all',
    data: {
        params: {}
    },
    methods: {
        register: function () {
            axios({
                url: 'register',
                method: "post",
                data: this.params
            }).then(function (resp) {
                layer.msg(resp.data.msg);
            }).catch(function (error) {
                console.log(error);
            })
        },
        verifypw: function () {
            axios({
                url: 'verifypw',
                method: "post",
                data: this.params
            }).then(function (resp) {
                $("#btn").show();
                if (resp.data == 1) {
                    layer.msg("两次密码不一致");
                    $("#btn").hide();
                }
            }).catch(function (error) {
                console.log(error);
            })
        }
    },
    created: function () {
    }
});