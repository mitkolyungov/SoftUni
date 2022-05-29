function isExcelent(input){

    let product = input[0];
    let day = input[1];
    if(day!="Monday" && day!="Tuesday" && day!="Wednesday" &&
    day!="Thursday" && day!="Friday" && day!="Saturday" && day!="Sunday"){
        console.log("error");
        return;
    }
    let quantity = Number(input[2]);   
    
    let price = 0;
    
    if(product == ("banana")){
        if(day == "Saturday" || day=="Sunday"){
            price = 2.7*quantity;
        }else{
            price = 2.5*quantity;
        }
        console.log(price.toFixed(2));
    }else if(product==("apple")){
        if(day == "Saturday" || day=="Sunday"){
            price = 1.25*quantity;
        }else{
            price = 1.2*quantity;
        }
        console.log(price.toFixed(2));
    }else if(product==("orange")){
        if(day == "Saturday" || day=="Sunday"){
            price = 0.9*quantity;
        }else{
            price = 0.85*quantity;
        }
        console.log(price.toFixed(2));
    }else if(product==("grapefruit")){
        if(day == "Saturday" || day=="Sunday"){
            price = 1.6*quantity;
        }else{
            price = 1.45*quantity;
        }
        console.log(price.toFixed(2));
    }else if(product==("kiwi")){
        if(day == "Saturday" || day=="Sunday"){
            price = 3*quantity;
        }else{
            price = 2.7*quantity;
        }
        console.log(price.toFixed(2));
    }else if(product==("pineapple")){
        if(day == "Saturday" || day=="Sunday"){
            price = 5.6*quantity;
        }else{
            price = 5.5*quantity;
        }
        console.log(price.toFixed(2));
    }else if(product==("grapes")){
        if(day == "Saturday" || day=="Sunday"){
            price = 4.2*quantity;
        }else{
            price = 3.85*quantity;
        }
        console.log(price.toFixed(2));
    }else{
        console.log("error")
    }
        
}


    
    