const mysql = require('mysql');
const express = require('express');
const bodyparser = require('body-parser')
const cors = require('cors');
const app = express();
// Body-parser middleware
app.use(bodyparser.urlencoded({extended:false}))
app.use(bodyparser.json())
app.use(cors());  

let mysqlConnection = mysql.createConnection(
    {
        host: "localhost",
        user: "root",
        password: "",
        database: "property_on_rent"
    }
);

mysqlConnection.connect((err)=>{
    if(!err)
        console.log('DB connection succeded.');
    else
        console.log('DB connection failed \n Error : '+JSON.stringify(err,undefined,2));
});

app.listen(3000,()=>console.log('Express server is running at port no : 3000'));

//Get All Roles
app.get('/role/getall',(req,res)=>{
    mysqlConnection.query('SELECT * FROM Role',(err,rows,fields)=>{
        if(!err)
            res.send(rows);
        else
            console.log(err);
    })
});


//Get A Role
app.get('/role/get/:roleid',(req,res)=>{
    mysqlConnection.query('SELECT * FROM Role WHERE role_id = ?',[req.params.roleid],(err,rows,fields)=>{
        if(!err)
            res.send(rows);
        else
            console.log(err);
    })
});


//delete A Role
app.delete('/role/delete/:roleid',(req,res)=>{
    mysqlConnection.query('DELETE FROM Role WHERE role_id = ?',[req.params.roleid],(err,rows,fields)=>{
        if(!err)
            res.send('Deleted Successfully');
        else
            console.log(err);
    })
});

//insert a role
app.post('/role/add', (req, res) => {
    role_name = req.body.role_name; 
    // console.log("roleName = ",req.body);
    let sql = "INSERT INTO `role`(role_name) VALUES(?)";
    mysqlConnection.query(sql, [role_name], 
    (err, rows, fields) => {
      if(!err) 
        res.send("Role successfully added!");
      else 
        console.log(err);
    });
  })

//rest api to update record into mysql database
app.put('/role/edit/:roleid', function (req, res) {
    mysqlConnection.query('UPDATE `role` SET `role_name`=? where `role_id`=?', [req.body.role_name,req.params.roleid], function (err, results, fields) {
       if (err) throw error;
            res.send("Role Updated Sucessfully!");
     });
 });


 //login
 app.get('/login',(req,res)=>{
    mysqlConnection.query('SELECT count(*) FROM RegistrationDetail WHERE email_id=? and password = ?',[req.body.emailId,req.body.password],(err,rows,fields)=>{
        if(!err)
            res.send(rows);
        else
            console.log(err);
    })
});
