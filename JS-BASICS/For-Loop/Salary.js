function salary(input) {
 
    let nOpenTabs = Number(input.shift()) ;
    let salary = Number(input.shift()) ;
 
 
 
    for (let i = 0; i < nOpenTabs; i++ ) {
 
       let tab = String(input[i]);
 
        if ( tab == `Facebook` ) {
 
            salary -= 150
            
 
        }
        if ( tab == `Instagram` ) {
 
            salary -= 100
 
        }
        if ( tab == `Reddit` ) {
 
            salary -= 50
 
        }
 
        if ( salary <= 0 ) {
 
            console.log(`You have lost your salary.`)
            return;
    
          }
 
        
       } // end of for
 
    console.log(salary)
    
 
 
    }