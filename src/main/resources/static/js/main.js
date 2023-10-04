const app = Vue.createApp({
    data() {
        return {
            marks: {

                speed100MSeconds: "00:00:00.000",
                longJumpMeters: 0,
                shotPutMeters: 0,
                highJumpMeters: 0,
                speed400MSeconds: "00:00:00.000",
                hurdles110MSeconds: "00:00:00.000",
                discThrowMeters: 0,
                poleVaultMeters: 0,
                javelinThrowMeters: 0,
                speed1500MSeconds: "00:00:00.000"
            },
            points: {

                speed100MSeconds: 0,
                longJumpMeters: 0,
                shotPutMeters: 0,
                highJumpMeters: 0,
                speed400MSeconds: 0,
                hurdles110MSeconds: 0,
                discThrowMeters: 0,
                poleVaultMeters: 0,
                javelinThrowMeters: 0,
                speed1500MSeconds: 0,
                total: 0
            }
        };
    },
    methods: {
        submitForm() {

            axios.post('/decathlon/calculate', this.marks)
                .then(response => {
                    this.points = response.data;

                })
                .catch(error => {
                    console.error('An error occurred while sending data to the server', error);

                });
        },
        resetForm() {
            this.marks = {
                speed100MSeconds: "00:00:00.000",
                longJumpMeters: 0,
                shotPutMeters: 0,
                highJumpMeters: 0,
                speed400MSeconds: "00:00:00.000",
                hurdles110MSeconds: "00:00:00.000",
                discThrowMeters: 0,
                poleVaultMeters: 0,
                javelinThrowMeters: 0,
                speed1500MSeconds: "00:00:00.000"
            };
            for (let field in this.points) {
                this.points[field] = 0;
            }
        }

    }
});

app.mount('#app');