const mysql = require('mysql');
const connection = mysql.createConnection({
    host:'localhost',
    user:'root',
    password:'',
    database:'property_on_rent'
});
connection.connect(function(error){
    console.log("hey");
    if(error) console.log(error);
    else console.log("connected....!");
})

module.exports = connection;