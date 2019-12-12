let vm = new Vue({
    el: '#all',
    data: {
        pageInfo: {},
        params: "",
    },
    methods: {
        selectAll: function (pageNum, pageSize) {
            this.pageInfo.pageNum = pageNum;
            this.pageInfo.pageSize = pageSize;
            axios({
                url: 'myUser',
                method:'post',
                data: this.pageInfo
            }).then(response => {
                    this.pageInfo = response.data;
            }).catch(function (error) {
                    console.log(error);
            })
        },
        lookmyUser:function (id) {
            axios({
                url: 'lookmyUser',
                params:{id:id}
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
        delMyUser:function (uId,focusId) {
            axios({
                url:'delMyUser',
                params:{uId:uId,focusId:focusId}
            }).then(resq=> {
                layer.msg(resq.data.msg);
                this.selectAll()
            }).catch(function (e) {
                console.log(e)
            })
        }
    },
    created: function () {
        this.selectAll();
    }
});