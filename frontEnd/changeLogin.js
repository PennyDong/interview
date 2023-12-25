//會員登入
const change_login = ()=> {
    document.querySelector('.content_font').style.display="none";
    document.querySelector('.ocpjp_photo').style.display="none";
    document.querySelector('.showSuccess').style.display="none";
    document.querySelector('.showLogin').style.display="block";
    document.querySelector('.showChat').style.display="none";
    document.querySelector('.showRegister').style.display="none";
    document.querySelector('.showPlayGuess').style.display="none";
    document.querySelector('.playGuess').style.display="none";
}

//個人簡介
const change_personal = ()=>{
    
    document.querySelector('.content_font').style.display="block";
    document.querySelector('.ocpjp_photo').style.display="block";
    document.querySelector('.showSuccess').style.display="none";
    document.querySelector('.showLogin').style.display="none";
    document.querySelector('.showChat').style.display="none";
    document.querySelector('.showRegister').style.display="none";
    document.querySelector('.showPlayGuess').style.display="none";
    document.querySelector('.playGuess').style.display="none";
}

//留言板
const change_chat = ()=>{
    document.querySelector('.showChat').style.display="block";
    document.querySelector('.content_font').style.display="none";
    document.querySelector('.ocpjp_photo').style.display="none";
    document.querySelector('.showSuccess').style.display="none";
    document.querySelector('.showLogin').style.display="none";
    document.querySelector('.showRegister').style.display="none";
    document.querySelector('.showPlayGuess').style.display="none";
    document.querySelector('.playGuess').style.display="none";
    //顯示留言
    chatList()
}
//登入功能
const handleLogin =() =>{

    const username = document.getElementById("id-username");
    const password = document.getElementById("id-password");

    fetch('http://localhost:8080/member/login',{
        method: 'POST',
        headers:{
            'Content-Type':'application/json',
        },
        body: JSON.stringify({username:username.value,password:password.value}),
    })
    .then(response => {
        if(response.ok){
            return response.json();
        }else
        {
            throw new Error('Login failed');
        }
    })
    .then(data =>{
        document.querySelector('.showSuccess').style.display='block';
        document.querySelector('.showLogin').style.display='none';
        console.log('ok');
    })
    .catch(error=>{
        console.error('Error',error);
        alert('帳號密碼有誤，請重新確認');
    });
};

//顯示註冊畫面

const change_Register = ()=>{
    document.querySelector('.showSuccess').style.display="none";
    document.querySelector('.showLogin').style.display="none";
    document.querySelector('.showRegister').style.display="block";
    document.querySelector('.playGuess').style.display="none";

}
//送出註冊
const handleRegister = ()=>{

    const name = document.getElementById("r-name");
    const username = document.getElementById("r-username");
    const password = document.getElementById("r-password");
    const email = document.getElementById("r-email");

    fetch('http://localhost:8080/member/register',{
        method: 'POST',
        headers:{
            'Content-Type':'application/json',
        },
        body: JSON.stringify({
            name :name.value,
            username:username.value,
            password:password.value,
            email:email.value
        }),
    })
    .then(response => {
        if(response.ok){
            return response.json();
        }else
        {
            console.log("註冊失敗")
            throw new Error('register failed');  
        }
    })
    .then(data =>{
        document.querySelector('.showLogin').style.display='block';
        document.querySelector('.showRegister').style.display='none';
        alert('註冊成功，請重新登入');
    })
    .catch(error=>{
        
        console.error('Error',error);
        alert('註冊失敗，請重新確認');
        
    });
};

//留言板功能
    //抓取所有留言內容
const chatList = ()=>{
    
    const chatList = document.getElementById("chatList");
    
       $.ajax({
        url:'http://localhost:8080/chatbox/chat',
        method:'GET',
        contentType:'application/json',
        success : (response)=>{
            $('#chatList').empty(); //clean old content
            response.forEach((chat)=>{
                var chatElement =`
                <div class="chat">
                    <p>姓名 : ${chat.name}</p>
                    <p>選項 : ${chat.subject}</p>
                    <p>內容 : ${chat.content}</p>
                </div>
                `;
                $('#chatList').append(chatElement);
            });
        },
        error: (error)=>{
            console.log('發生錯誤',error);
        }      
    })
}

//清除留言輸入框的內容
const resetChat = ()=>{
    document.getElementById("cName").value="";
    document.getElementById("cSubject").value="";
    document.getElementById("cContent").value="";

}
//送出留言
const submitContent = ()=>{

    const Name=document.getElementById("cName");
    const Subject=document.getElementById("cSubject");
    const Content=document.getElementById("cContent");
    
    var dataRequest = {
        name:Name.value,
        subject:Subject.value,
        content:Content.value
    }

    $(document).ready(()=>{
        $.ajax({
            url:'http://localhost:8080/chatbox/submitChat',
            method:'POST',
            data:JSON.stringify(dataRequest),
            contentType:'application/json',
            success:(response)=>{
                
                console.log('成功',response);
                resetChat();
                alert('留言成功');
                chatList();
            },
            error: (error)=>{
                console.log('失敗',error);
            },
        
        })
    })
    
}
//顯示猜數字遊戲畫面
const guessNumber = ()=>{

    document.querySelector('.showPlayGuess').style.display="block";
    document.querySelector('.playGuess').style.display="block";
    document.querySelector('.guessList').style.display="block";
    document.querySelector('.guessFont').style.display="block"
    document.querySelector('.showSuccess').style.display='none';
}


//事件處理 檢查欄位內容字數
const numInputs = document.querySelectorAll('.num');

const checkNumber = (event)=>{
    const objEle = event.target.value;
    if(objEle.length>1){
        alert('輸入的數字只能為一個');
    };
};
numInputs.forEach(input=>{
    input.addEventListener("input",checkNumber);
})

//檢查送出的資料中有沒有不正確的格式
const isSingleNumber = (value)=>{
        return value!=null&&value.length>1;
}

//送出答案
const submitGuess = ()=>{
    
    const num1Value = document.getElementById('num1').value;
    const num2Value = document.getElementById('num2').value;
    const num3Value = document.getElementById('num3').value;
    const num4Value = document.getElementById('num4').value;

    var dataGuess = {
        num1:num1Value,
        num2:num2Value,
        num3:num3Value,
        num4:num4Value
    };

    console.log(dataGuess);

    if(isSingleNumber(num1Value)||
        isSingleNumber(num2Value)||
        isSingleNumber(num3Value)||
        isSingleNumber(num4Value)
        ){
        alert("每欄位只能填寫一個數字");
    }else{
        $.ajax({
            url:'http://localhost:8080/play/guess',
            method:'POST',
            data:JSON.stringify(dataGuess),
            contentType:'application/json',
            success:(response)=>{
                console.log('ok');
                var guessResult=
                `
                <div class="gList">    
                    <p>結果:${response}</p>
                </div>
                `
                $('#gList').append(guessResult);
                
                resetGuess();
                }
            }
        )
        
    }
}

//清除輸入框答案
resetGuess = ()=>{
    
    const numInput = document.querySelectorAll('.num');
    numInput.forEach(input=>{
        input.value = '';
    })
    
}

//重新開始遊戲
resetPlay = ()=>{

    $.ajax({
        url:'http://localhost:8080/play/resetPlay',
        method:'POST',
        contentType:'application/json',
        success:(response)=>{
                
            console.log('開始新遊戲',response);
            resetGuess();
            alert('開始新遊戲');
        },
        error: (error)=>{
            console.log('失敗',error);
        },
    })
}