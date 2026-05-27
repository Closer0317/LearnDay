document.querySelector('#doLogin').addEventListener('click', ()=>{
    const username = document.getElementById('loginUsername').value;
    const password = document.getElementById('loginPassword').value;
    // const token = document.getElementById('loginToken').value;
    if (!username || !password) {
        alert('请输入用户名和密码');
        return;
    }
    axios.post('http://localhost:8080/user/login', { username, password})
        .then(response => {
        console.log('登录成功', response.data);
        sessionStorage.setItem('user', JSON.stringify(response.data.data)); // 将用户信息存储在 sessionStorage 中
        alert('登录成功！');
        window.location.href = 'userCenter.html'; // 登录成功后跳转到主页
        })
            .catch(error => {
                console.error('登录失败', error);
                alert('登录失败，请检查用户名和密码');
            });
    });
    // 登录逻辑
