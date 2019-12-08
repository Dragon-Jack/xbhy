let vm = new Vue({
    el: '#all',
    data: {
        params:{}
    },
    methods: {
        verify:function(){
            axios({
                url: 'verify',
                params:this.params
            }).then(function (resp) {
                layer.msg(resp.data.msg);
            }).catch(function (error) {
                console.log(error);
            })
        },
        forget: function () {
            axios({
                url: 'forget',
                method:"post",
                data:this.params
            }).then(function (resp) {
                layer.msg(resp.data.msg);
            }).catch(function (error) {
                console.log(error);
            })
        }
    },
    created: function () {
    }
});