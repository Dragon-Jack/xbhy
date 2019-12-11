let vm = new Vue({
    el: '#all',
    data: {
        params: {},
        pageInfo:{}
    },
    methods: {
        lookUser: function (pageNum,pageSize) {
            this.params.pageNum=pageNum;
            this.params.pageSize=pageSize;
            axios({
                url: 'lookUser',
                method:"post",
               data: this.params
            }).then(resp=> {
                this.pageInfo=resp.data;
                console.log(this.pageInfo);
            }).catch(function (error) {
                console.log(error);
            })

        },
        toLookUser:function (id) {
            axios({
                url: 'toLookUser',
                params: {id:id}
            }).then(function (resp) {
                layer.appVersion = resp.data;
                layer.open({
                    type: 2,
                    title: "资质审核",
                    content: "user_detail",
                    area: ["60%", "80%"],
                    end: () => {

                    }
                })

            }).catch(function (e) {
                console.log(e);
            })
        }
    },
    created: function () {
        this.lookUser();//在vue创建后调用函数返回数据
    }
});