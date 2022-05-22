const express = require('express');
const app = express();
const router = express.Router();
const connectionObj = require('./db');

router.get('/get',function(req,res){
    connectionObj.query("select * from property order by prperty_id",function(err,rows){
        if(err){
            req.flash('error',err);
            res.render('property',{data:''});
        }else{
            res.render('properties',{data:rows});
        }
    });
});
router.listen(8080);
