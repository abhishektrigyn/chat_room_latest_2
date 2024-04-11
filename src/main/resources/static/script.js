var stompClient=null



   function sendMessage(sendFlag){

debugger;
  
   //S alert("jsonOb "+jsonOb);
   	// console.log(value);
	debugger;
     event.preventDefault();
   var msgIdNew;
   var message=$("#message-value").val();
      //  fire_ajax_submit();
      var json = {"username":$("#name-value").val(),"password":$("#password-value").val(),"message":message,"messageId":""}
  $.post({
     url : '/login/insertMessage',
     type: "POST",
     dataType: "json",
     contentType: "application/json; charset=utf-8",
     async:false,
     data : JSON.stringify(json),
     success : function(res) {
		// alert("response "+res);
		 debugger;
		 msgIdNew=res.messageId;

         console.log(res)
     }
  })
	

  //  stompClient.send("/app/message",{},JSON.stringify(jsonOb));
    let jsonOb={
		
        name:localStorage.getItem("name"),
        //content:$("#message-value").val()
        data:$("#message-value").val(),
        password:localStorage.getItem("password"),
        sendFlag:sendFlag,
        messageIdNew:msgIdNew
    }
    stompClient.send("/chat/message",{},JSON.stringify(jsonOb));



   }

function deleteConnect(removeMessageId)
{

debugger;
    let jsonOb={
		
        name:localStorage.getItem("name"),
        //content:$("#message-value").val()
        data:$("#message-value").val(),
        password:localStorage.getItem("password"),
        removeMessageId:removeMessageId
    }
   //S alert("jsonOb "+jsonOb);

  //  stompClient.send("/app/message",{},JSON.stringify(jsonOb));
    stompClient.send("/chat/message",{},JSON.stringify(jsonOb));




}
function deleteMessage(deleteIds)
{
	debugger;
	        event.preventDefault();

      //  fire_ajax_submit();
      //var json = {"username":$("#name-value").val(),"password":$("#password-value").val()}
      var json = {"username":localStorage.getItem("name"),"password":localStorage.getItem("password"),"deleteIds":deleteIds}
  $.post({
     url : '/login/delete',
     type: "POST",
     dataType: "json",
     contentType: "application/json; charset=utf-8",
     data : JSON.stringify(json),
     success : function(res) {
		// alert("response "+res);
		 debugger;
         console.log(res)
          // $(".checkbox input:checked").parent().remove();
var array = deleteIds.split(",");
for(var i=0;i<array.length;i++)
{
	
	var id=array[i];
	$('#tblr'+id).remove();
	//connect();
	deleteConnect(id);
}


  //       let name=$("#name-value").val()
  //let password=$("#password-value").val()

  //     localStorage.setItem("name",name)
  //            localStorage.setItem("password",password)

  //     $("#name-title").html(`Welcome , <b>${name} </b>`)
   //   connect(res,true);
     }
  })
}
function connect(history)
{
debugger;
        let socket=new SockJS("/server")

        stompClient=Stomp.over(socket)

        stompClient.connect({},function(frame){

            console.log("Connected : "+frame)

            $("#name-from").addClass('d-none')
              $("#chat-room").removeClass('d-none')

//$("#message-container-table").prepend(`<tr><td><b>${history.messages[0].messageId} :</b> ${history.messages[0].message}</td></tr>`)

debugger;
for(var i=0;i<history.messages.length;i++)
{
	var msgId=history.messages[i].messageId;
	var msg=history.messages[i].message;
	
$("#message-container-table").prepend(`<tr id	=tblr${msgId}><td><b>${localStorage.name} :</b> ${msg}  <td><input id=chk${msgId} type="checkbox" value=${msgId} />    </td></td></tr>`)

}

                //subscribe
                stompClient.subscribe("/topic/sendbackurl",function(response){
                 debugger;
  var obj = jQuery.parseJSON(response.body);
  var removeMessageId=obj.removeMessageId;
  var  messageIdNew=obj.messageIdNew;
  if(typeof obj.removeMessageId === "undefined" || obj.removeMessageId == null)
  {
	  debugger;
	  //var sendFlag;
  debugger;
var localSessionName=localStorage.getItem("name");
var callBackName=obj.name;
let check=localSessionName.localeCompare(callBackName);
if(check===0)
{
  var msgToSend="";
$.each(obj, function(key,value) {
  //alert(value.com);
  let ans = key.localeCompare('sendFlag');
  let ans1=key.localeCompare('data');
  if(ans1===0)
  {
	  msgToSend=value;
  }
 if (ans === 0) {

	 }

}); 
debugger;
               //  showMessage(JSON.parse(response.body),msgId);
               showMessage(JSON.parse(response.body),messageIdNew);

}
else
{
	debugger;
	                 showMessage(JSON.parse(response.body));

}
  }
  else
  {
  debugger;
  $('#tblr'+removeMessageId).remove();
  	//$('#tblr'+id).remove();

  
}


                })



        })
        

}


 function showMessage(message)
 {
	// alert("message history "+history)
	 
debugger;
var msgId=0;
   // $("#message-container-table").prepend(`<tr><td><b>${history.messages[i].messageId} :</b> ${history.messages[i].message}</td></tr>`)
$("#message-container-table").prepend(`<tr id	=tblr${msgId}><td><b>${message.name} :</b> ${message.data}  <td><input id=chk${msgId} type="checkbox" value=${msgId} />    </td></td></tr>`)

 //   $("#message-container-table").prepend(`<tr><td><b>${message.name} :</b> ${message.data}</td></tr>`)
 // $("#message-container-table").prepend('<tr><td><b>${message.name} :</b> ${message.data}</td></tr>')
 }

function showMessage(message,msgId)
 {
	// alert("message history "+history)
	 
debugger;
var localSessionName=localStorage.getItem("name");
var callBackName=message.name;
var messageIdNew=message.messageIdNew;
let check=localSessionName.localeCompare(callBackName);
var removeMessageId   = message.removeMessageId;
if(typeof messageIdNew !== "undefined" || messageIdNew != null)
{
	msgId=messageIdNew;
}
else if(typeof removeMessageId !== "undefined" || removeMessageId != null)
{
	msgId=removeMessageId;
}
if(check===0)
{
   // $("#message-container-table").prepend(`<tr><td><b>${history.messages[i].messageId} :</b> ${history.messages[i].message}</td></tr>`)
$("#message-container-table").prepend(`<tr id	=tblr${msgId}><td><b>${message.name} :</b>${message.data}<td><input id=chk${msgId} type="checkbox" value=${msgId} />    </td></td></tr>`)

}
else{
	$("#message-container-table").prepend(`<tr id	=tblr${msgId}><td><b>${message.name} :</b>${message.data}</td></tr>`)
 	//$("#message-container-table").prepend(`<tr id	=tblr${msgId}><td><b>${localSessionName} :</b>${message.data}</td></tr>`)
  if(typeof messageIdNew === "undefined" || messageIdNew == null)
  {
	  	$('#tblr'+messageIdNew).remove();

  }

}
 //   $("#message-container-table").prepend(`<tr><td><b>${message.name} :</b> ${message.data}</td></tr>`)
 // $("#message-container-table").prepend('<tr><td><b>${message.name} :</b> ${message.data}</td></tr>')
 }

$(document).ready((e)=>{


   $("#login").click(()=>{


      // let name=$("#name-value").val()
       //localStorage.setItem("name",name)
       ///$("#name-title").html(`Welcome , <b>${name} </b>`)
       //connect();

debugger;
        //stop submit the form, we will post it manually.
        event.preventDefault();

      //  fire_ajax_submit();
      var json = {"username":$("#name-value").val(),"password":$("#password-value").val()}
$.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/login/check",
        data: JSON.stringify(json),
       dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
  debugger;
	if(data.validUser=='YES'){		
for(var i=0;i<data.messages.length;i++)
{
	var msgId=data.messages[i].messageId;
		var msg=data.messages[i].message;

}

           
 let name=$("#name-value").val()
  let password=$("#password-value").val()

       localStorage.setItem("name",name)
              localStorage.setItem("password",password)

       $("#name-title").html(`Welcome , <b>${name} </b>`)
      connect(data);
}
else
{
alert("Invalid Credentials");

	 // $("#name-title").html(`Invalid Credentials`)
}
        },
        error: function (e) {

debugger;
            alert("error "+e)

        }
    });
   })

$("#delete-btn").click(()=>{
	debugger;
	//$('input[type=checkbox]').each(function () {
   // var sThisVal = $('.theClass:checkbox:checked')
 var sThisVal=  $('input[type=checkbox]:checked').map(function(_, el) {
     //console.log($(el).val())
      return $(el).val();
     
}).get().join(",");
console.log(sThisVal);
if (sThisVal==="") {
		alert("Please select atlease one record.");
}
else
{
	deleteMessage(sThisVal);
}
    debugger;
});
   })
   //$("#sendbtn").click(()=>{
	//event.preventDefault();

   // sendMessage();
   //})

	//$("#logout").click(()=>{

    
//})
function logout()
{
	debugger;
	localStorage.removeItem("name")
    if(stompClient!==null)
    {
        stompClient.disconnect()

         $("#name-from").removeClass('d-none')
         $("#chat-room").addClass('d-none')
         console.log(stompClient)
    }
window.location.replace("http://localhost:8080/");

}
$("#logincheck").submit(function (event) {
debugger;
        //stop submit the form, we will post it manually.
        event.preventDefault();

      //  fire_ajax_submit();
      var json = {"username":$("#name-value").val(),"password":$("#password-value").val()}
  $.post({
     url : '/login/check',
     type: "POST",
     dataType: "json",
     contentType: "application/json; charset=utf-8",
     data : JSON.stringify(json),
     success : function(res) {
		// alert("response "+res);
		 debugger;
         console.log(res)
         
     }
  })

    });

