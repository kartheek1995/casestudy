var addresslist=[];

if(location.pathname=='/ShoppingBee/static/html/account.htm'){
    $.getJSON("/ShoppingBee/address/list",function(result){
    addresslist=result;
});
}

$(document).ajaxStop(function(){
    $(document).ready(function(){
if(document.URL=='http://localhost:8080/ShoppingBee/static/html/register.htm?status=failure'
        || document.URL=='http://localhost:8080/ShoppingBee/static/html/account.htm?state=failure'){
$("#some").show();
}
var ss =  document.URL.slice(document.URL.indexOf('=')+1);
if(ss=='success'|| ss=='success1'|| ss=='success2'||ss=='success3'){
    $("#save").show();
}
else if(ss=='error3'){
    $("#cant").show();
}
for(var i=1;i<=addresslist.length;i++){
    $("#address").append(appendAddress(i-1));
}
});
});
$("#registerForm").submit(function(){
    // do other things for a valid form
    var a=  $('#uname').val();
    var b=  $('#pwd').val();
    var c=  $('#cpwd').val();
    var f= $('#mob').val();
    var g= $('#fname').val();
    var h= $('#lname').val();
    var i=0;
    if((/[ ]/).test(g) || g===""){
        $('#namef').show();
        i+=1;
    }
    else{
        $('#namef').hide();
    }
    if((/[ ]/).test(h) || h===""){
        $('#namel').show();
        i+=1;
    }
    else{
        $('#namel').hide();
    }

    if(!(/^[a-z]+$/).test(a)){
        $('#nameu').show();
        i+=1;
    }
    else{
        $('#nameu').hide();
    }

    if(!(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).+$/).test(b)){
        $('#pass').show();
        i+=1;
    }
    else{
        $('#pass').hide();
    }
      if(b!=c){
        $('#pass2').show();
        i+=1;
    }
    else{
        $('#pass2').hide();
    }

    if(!(/^\d{10}$/).test(f)){
        $('#cell').show();
        i+=1;
    }
    else{
        $('#cell').hide();
    }


    if(i>=1){
        return false;
    }
    
});


$("#edit").submit(function(){
    // do other things for a valid form
    var a=  $('#uname').val();
    var f= $('#mob').val();
    var g= $('#fname').val();
    var h= $('#lname').val();
    var i=0;
    if((/[ ]/).test(g) || g===""){
        $('#namef').show();
        i+=1;
    }
    else{
        $('#namef').hide();
    }
    if((/[ ]/).test(h) || h===""){
        $('#namel').show();
        i+=1;
    }
    else{
        $('#namel').hide();
    }

    if(!(/^[a-z]+$/).test(a)){
        $('#nameu').show();
        i+=1;
    }
    else{
        $('#nameu').hide();
    }

    if(!(/^\d{10}$/).test(f)){
        $('#cell').show();
        i+=1;
    }
    else{
        $('#cell').hide();
    }


    if(i>=1){
        return false;
    }
    
});


$("#edit1").submit(function(){
    // do other things for a valid form
    var b=  $('#pwd').val();
    var c=  $('#cpwd').val();
 
    var i=0;
    if(!(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).+$/).test(b)){
        $('#pass').show();
        i+=1;
    }
    else{
        $('#pass').hide();
    }
      if(b!=c){
        $('#pass2').show();
        i+=1;
    }
    else{
        $('#pass2').hide();
    }

    if(i>=1){
        return false;
    }
    
});

function appendAddress(i){
    var addressdiv = '<div class="panel-group col-xs-9"><div class="panel panel-primary"><div class="panel-heading">'+
                   ' Address '+(i+1)+'<a href="http://localhost:8080/ShoppingBee/deleteaddress/id='+addresslist[i].addressId+'"><button class="img-circle" style="float: right;color: #337ab7"><span>&times</span>'+
                   ' </button></a></div><div class="panel-body"><p>'+addresslist[i].houseno+'</p><p>'+addresslist[i].houseno.street+'</p>'+
                    '<p>'+addresslist[i].city+'</p><p>'+addresslist[i].state+'</p><p>'+addresslist[i].pincode+'</p><p>Address type: '+addresslist[i].addresstype+'</p></div></div></div>'
    return addressdiv;
}






