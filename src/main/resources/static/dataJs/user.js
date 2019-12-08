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
                console.log(this.pageInfo.list);
            }).catch(function (error) {
                console.log(error);
            })

        }

    },
    created: function () {
        this.lookUser();//在vue创建后调用函数返回数据
        console.log(this.pageInfo.list);
    }
});