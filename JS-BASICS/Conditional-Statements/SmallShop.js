function isExcelent(input){

    let product = input[0];
    let city = input[1];
    let quantity = Number(input[2]);   
    
    let price = 0;
    
    if(product == ("coffee")){
        if(city == ("Sofia")){
            price = 0.5*quantity;
        }else if(city==("Plovdiv")){
            price = 0.4*quantity;
        }else if(city==("Varna")){
            price = 0.45*quantity;
        }
    }else if(product==("water")){
        if(city==("Sofia")){
            price = 0.8*quantity;
        }else if(city==("Plovdiv")){
            price = 0.7*quantity;
        }else if(city==("Varna")){
            price = 0.7*quantity;
        }
    }else if(product==("beer")){
        if(city==("Sofia")){
            price = 1.2*quantity;
        }else if(city==("Plovdiv")){
            price = 1.15*quantity;
        }else if(city==("Varna")){
            price = 1.1*quantity;
        }
    }else if(product==("sweets")){
        if(city==("Sofia")){
            price = 1.45*quantity;
        }else if(city==("Plovdiv")){
            price = 1.3*quantity;
        }else if(city==("Varna")){
            price = 1.35*quantity;
        }
    }else if(product==("peanuts")){
        if(city==("Sofia")){
            price = 1.6*quantity;
        }else if(city==("Plovdiv")){
            price = 1.5*quantity;
        }else if(city==("Varna")){
            price = 1.55*quantity;
        }
    }
    
    console.log(price);
    
    }
    
    