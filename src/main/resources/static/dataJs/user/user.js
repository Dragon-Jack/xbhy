let vm = new Vue({
    el: '#all',
    data: {
        params: {},
        pageInfo: {}
    },
    methods: {
        lookUser: function (pageNum, pageSize) {
            this.params.pageNum = pageNum;
            this.params.pageSize = pageSize;
            axios({
                url: 'lookUser',
                method: "post",
                data: this.params
            }).then(resp => {
                this.pageInfo = resp.data;
            }).catch(function (error) {
                console.log(error);
            })

        },
        toLookUser: function (id) {
            axios({
                url: 'toLookUser',
                params: {id: id}
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
        },
        toAttention: function (yesId, focusId) {
            console.log(this.pageInfo.list);
            axios({
                url: 'toAttention',
                params: {
                    yesId: yesId,
                    focusId: focusId
                }
            }).then(resp=> {
                layer.msg(resp.data.msg);
                this.lookUser();
            }).catch(function (e) {
                console.log(e)
            })
        }
    },
    created: function () {
        console.log(this.pageInfo.list);
        this.lookUser();//在vue创建后调用函数返回数据
    }
});