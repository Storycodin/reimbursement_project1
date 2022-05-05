window.onload = function () {
    getAllReimbur()
    document.getElementById("logoutButton").addEventListener("click", logout);
    document.getElementById("Approved").addEventListener("click", approved);
    document.getElementById("Denied").addEventListener("click", denied);
}



function printAllPending(reimbur) {
    console.log(reimbur)
    let varOl = document.getElementById("displayedPending");
    varOl.innerHTML = "";
        for (let i = 0; i < reimbur.length; i++) {
            if (reimbur[i].statusId == 1) {
                let spaceing = document.createTextNode("  -  ");
                let varLi = document.createElement("li");

                //order, spacing, and what varables to print
                varLi.appendChild(document.createTextNode(reimbur[i].reimbursId));
                varLi.appendChild(spaceing.cloneNode());

                varLi.appendChild(document.createTextNode(reimbur[i].amount));
                varLi.appendChild(spaceing.cloneNode());

                varLi.appendChild(document.createTextNode(reimbur[i].description));
                varLi.appendChild(spaceing.cloneNode());

                // varLi.appendChild(document.createTextNode(reimbur[i].statusId));
                // varLi.appendChild(spaceing.cloneNode());
                varLi.appendChild(document.createTextNode(reimbur[i].status));
                varLi.appendChild(spaceing.cloneNode());

                varLi.appendChild(document.createTextNode(reimbur[i].type));

                //each reimburement on its own line
                varOl.appendChild(varLi);
            }//if
        }//for
        return reimbur;
}//print pending


function printAllApproved(reimbur) {
    let varOl = document.getElementById("displayedApproved");
    varOl.innerHTML = "";
    try {
        for (let i = 0; i < reimbur.length; i++) {
            console.log(reimbur[i].statusId)
            if (reimbur[i].statusId == 2) {
                console.log(i)
                let spaceing = document.createTextNode("  -  ");
                let varLi = document.createElement("li");

                //order, spacing, and what varables to print
                varLi.appendChild(document.createTextNode(reimbur[i].reimbursId));
                varLi.appendChild(spaceing.cloneNode());

                varLi.appendChild(document.createTextNode(reimbur[i].amount));
                varLi.appendChild(spaceing.cloneNode());

                varLi.appendChild(document.createTextNode(reimbur[i].description));
                varLi.appendChild(spaceing.cloneNode());

                // varLi.appendChild(document.createTextNode(reimbur[i].statusId));
                // varLi.appendChild(spaceing.cloneNode());
                varLi.appendChild(document.createTextNode(reimbur[i].status));
                varLi.appendChild(spaceing.cloneNode());

                varLi.appendChild(document.createTextNode(reimbur[i].type));


                //each reimburement on its own line
                varOl.appendChild(varLi);
            }//if
        }//for
        return reimbur;
    } catch { }//try catch
}//print Approved


function printAllDenied(reimbur) {
    let varOl = document.getElementById("displayedDenied");
    varOl.innerHTML = "";
    try {
        for (let i = 0; i < reimbur.length; i++) {

            if (reimbur[i].statusId == 3) {
                let spaceing = document.createTextNode("  -  ");
                let varLi = document.createElement("li");


                //order, spacing, and what varables to print
                varLi.appendChild(document.createTextNode(reimbur[i].reimbursId));
                varLi.appendChild(spaceing.cloneNode());

                varLi.appendChild(document.createTextNode(reimbur[i].amount));
                varLi.appendChild(spaceing.cloneNode());

                varLi.appendChild(document.createTextNode(reimbur[i].description));
                varLi.appendChild(spaceing.cloneNode());

                // varLi.appendChild(document.createTextNode(reimbur[i].statusId));
                // varLi.appendChild(spaceing.cloneNode());
                varLi.appendChild(document.createTextNode(reimbur[i].status));
                varLi.appendChild(spaceing.cloneNode());

                varLi.appendChild(document.createTextNode(reimbur[i].type));

                //each reimburement on its own line
                varOl.appendChild(varLi);
            }//if
        }//for
        return reimbur;
    } catch { }//try catch
}//print denied


/////////////////////////////////////////////DB functions
function approved() {

    let id = document.getElementById('ChangeID').value;

    let reimToChange = {
        reimbursId: id,
        statusId: 2,
    }

    console.log("ID = " + id)
    // STEP 1: create the XMLHttpRequest Object
    let xhttp = new XMLHttpRequest();

    // STEP 2: create the callback function for readyState changes
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("readyState is 4!!! AND status is 200!!! addNewReim");
            let varOl = document.getElementById("displayedApproved");
            varOl.innerHTML = "Loading";
            getAllReimbur();
        }
    }
    // STEP 3: prepare connection/request details
    xhttp.open('put', `http://localhost:8080/reimbursement_project1/financeManager/update-reimburs-status`);

    // STEP 4: send the request, providing any body object the request needs
    xhttp.setRequestHeader("content-type", "application/json")
    xhttp.send(JSON.stringify(reimToChange));
};

function denied() {

    var id = document.getElementById('ChangeID').value;

    let reimToChange = {
        reimbursId: id,
        statusId: 3,
    }


    // STEP 1: create the XMLHttpRequest Object
    let xhttp = new XMLHttpRequest();

    // STEP 2: create the callback function for readyState changes
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("readyState is 4!!! AND status is 200!!! addNewReim");
            let varOl = document.getElementById("displayedDenied");
            varOl.innerHTML = "Loading";
            getAllReimbur();
        }
    }
    // STEP 3: prepare connection/request details
    xhttp.open('put', `http://localhost:8080/reimbursement_project1/financeManager/update-reimburs-status`);

    // STEP 4: send the request, providing any body object the request needs
    xhttp.setRequestHeader("content-type", "application/json")
    xhttp.send(JSON.stringify(reimToChange));
};




function getAllReimbur() {
    // STEP 1: create the XMLHttpRequest Object
    let xhttp = new XMLHttpRequest();

    // STEP 2: create the callback function for readyState changes
    xhttp.onreadystatechange = function () {

        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("readyState is 4!!! AND status is 200!!!");
            // console.log("my response: " + xhttp.responseText);

            let reimbur = JSON.parse(xhttp.responseText);
            console.log(reimbur)
            printAllDenied(printAllApproved(printAllPending(reimbur)));

        }
    }

    //  STEP 3: prepare connection/request details
    xhttp.open('GET', `http://localhost:8080/reimbursement_project1/financeManager/all-reimburs`);
    // STEP 4: send the request, providing any body object the request needs
    xhttp.send();
}//getAllReimbur




function logout() {
    // STEP 1: create the XMLHttpRequest Object
    let xhttp = new XMLHttpRequest();

    // STEP 2: create the callback function for readyState changes
    xhttp.onreadystatechange = function () {

        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("readyState is 4!!! AND status is 200!!!");
            console.log("my response: " + xhttp.responseText);

            window.location.href = JSON.parse(xhttp.responseText);
        }
    }

    //  STEP 3: prepare connection/request details
    xhttp.open('POST', `http://localhost:8080/reimbursement_project1/login/logout`);
    // STEP 4: send the request, providing any body object the request needs
    xhttp.send();
}
