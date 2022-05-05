// reimbursment_project1/index.js

function test(){
    let text = "this is working!"
    document.getElementById("test").innerText = text;
    
};
window.onload = function(){
    // document.getElementById("myButton").addEventListener("click", test);
    document.getElementById("myButton").addEventListener("click", login);
    //for testing purpuses not to be in the final product (?)
    // document.getElementById("myButton").addEventListener("click", accountType);
}



function login(){
    let myName = document.getElementById("username").value;
    let myPass = document.getElementById("password").value;
      
    let login = {
        username : myName,
        password : myPass
    }
    //step 1
      let xhttp = new XMLHttpRequest();
      
      /*
      STEP 2: create the callback function for readyState changes
      
    READY STATES:
    The XMLHttpRequest object has serveral states we need to know about
            
    state 0:    not initialized
    state 1:    server connection established
    state 2:    request received
    state 3:    processing request
    state 4:    complete, request finished and response is ready
        */
       //this is the response 
    xhttp.onreadystatechange = function (){
        console.log("readyState is changing: ", xhttp.readyState);
        
        if(xhttp.readyState==4 && xhttp.status ==200){
            console.log("readyState is 4!!! AND status is 200!!!");
            console.log("my response: " + xhttp.responseText);

            window.location.href = JSON.parse(xhttp.responseText);
        }
    }
    
        
        
    /*
    STEP 3: prepare connection/request details
    (readyState goes from 0 to 1 here)
    
    xhttp.open(httpMethod, url);
    OR
    xhttp.open(httpMethod, url, ?optional? boolean async); <-----defaults to true for the boolean
    */
    xhttp.open('post', `http://localhost:8080/reimbursement_project1/login/login`);
    
    
    /*
    STEP 4: send the request, providing any body object the request needs    
    xhttp.send(myRequestBodyObject);
    */
   
   console.log(login)
    //into json
    xhttp.setRequestHeader("content-type", "application/json")
    xhttp.send(JSON.stringify(login));


}