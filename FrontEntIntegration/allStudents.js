// function for displaying all the sutdent details

function allData(){

    const studentTableBody = document.getElementById('student-table-body');

    fetch("http://localhost:8888/students").then(response => {
        if(response.status == 201 | response.status == 200){
            response.json().then(data => {
               
               data.forEach(student =>{

                const row = document.createElement('tr');
                row.innerHTML = `
                <tr>
                    <td>${student.roll}</td> 
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                    <td>${student.marks}</td>
                    <td>
                        <button class="button" onclick="updateRecord('${student.name}','${student.age}','${student.marks}')">UPDATE</button> 
                    </td>
                    <td>
                        <button class="delete" onclick="deleteRecord(${student.roll})">DELETE</button> 
                    </td>
                </tr>
                `;
                studentTableBody.appendChild(row);
                
                })})
        }else{
            response.json().then(data => alert(data.message));
        }
    })

}

function deleteRecord(roll){
    
    let choice= confirm("Are You Sure ?");

    if(choice){
    fetch("http://localhost:8888/student/"+roll, {

    method: "DELETE"
   
}).then(response => {
    if(response.status == 201 | response.status == 200){
        response.json().then(data => {
            alert("Student sucessfully deleted: ");
            location.reload();
        });
    }else{
        response.json().then(data => alert(data.message));
    }
})
    }

}


function updateRecord(name,age,marks) {
   
    const url = `updateStudent.html?name=${name}&address=${age}&marks=${marks}`;

    location.href= url;

   
  }

