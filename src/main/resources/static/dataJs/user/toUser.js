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
                console.log(this.appVersion);
            }).catch(function (e) {
                console.log(e)
            })
        console.log(this.appVersion)
        }

    },
    created: function () {
        this.appVersion=parent.layer.appVersion
    }
});