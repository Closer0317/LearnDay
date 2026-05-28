document.querySelector('#doRegister').addEventListener('click', ()=>{
    const username = document.getElementById('regUsername').value;
            const pwd = document.getElementById('regPassword').value;
            const confirm = document.getElementById('regConfirmPwd').value;
            const phone = document.getElementById('regPhone').value;
            if (!username || !pwd) {
                alert('请填写完整');
                return;
            }
            if (pwd !== confirm) {
                alert('两次密码不一致');
                return;
            }
            axios.post('http://127.0.0.1:8080/user/register', { username, password: pwd, phone })
                .then(response => {
                    console.log('注册成功', response.data);
                    alert('注册成功！请登录');
                    showLogin(); // 注册成功后切换到登录表单
                })
                .catch(error => {
                    console.error('注册失败', error);
                    alert('注册失败，请重试');
                });
});