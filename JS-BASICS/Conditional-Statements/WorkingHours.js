function isExcelent(input){

    let time = Number(input[0]); 
    let day = input[1];
    
    if((time>18  || time<10) || (day=="Sunday")){
        console.log("closed");
    }else{
        console.log("open");
    }
    }
    
    
    
    