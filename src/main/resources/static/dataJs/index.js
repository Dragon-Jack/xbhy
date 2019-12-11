let vm = new Vue({
    el: '#all',
    data: {
        params: {},
    },
    methods: {
        login: function () {
            axios({
                url: 'login',
                method:"post",
                data:this.params
            }).then(function (resp) {
                if (resp.data == null || resp.data == "") {
                    location.href="home";
                }else
                layer.msg(resp.data.msg);
            }).catch(function (error) {
                console.log(error);
            })
        }
    },
    created: function () {
        axios({
            url: 'getSession'
        }).then(function (resp) {
            if (resp.data=="Free") {
                location.href="home";
            }
        }).catch(function (e) {
            console.log(e)
        })
    }
});