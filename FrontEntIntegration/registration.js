function registerStudent(){

    let sname=document.getElementById("name").value;
    let sroll=document.getElementById("roll").value;
    let sage = document.getElementById("age").value;
    let smarks=document.getElementById("marks").value;
    
    fetch("http://localhost:8888/student", {

        method: "POST",
        headers: {
            "content-type": "application/json"
        },
        body: JSON.stringify({
            "roll":sroll,
            "name": sname,
            "age": sage,
            "marks": smarks
        })
    }).then(response => {
        if(response.status == 201 | response.status == 200){
            response.json().then(data => {
                alert("Student sucessfully registered with Roll: "+data.roll)
                location.reload();
            });
        }else{
            response.json().then(data => alert(data.message));
        }
    })


}