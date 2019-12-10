let vm = new Vue({
    el: '#all',
    data: {
        appVersion: {}
    },
    methods: {
        lookUser: function () {
            axios({
                url:'toLookUser',
                params:{id:this.appVersion.id}

            }).then(resp=> {
                this.appVersion=resp.data;

            }).catch(function (e) {
                console.log(e)
            })
        console.log(this.appVersion)
        }

    },
    created: function () {
        this.appVersion=parent.layer.appVersion
        this.lookUser();//在vue创建后调用函数返回数据
    }
});