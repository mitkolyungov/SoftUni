function examPreparation(input) {
    let numberBadGrades = Number(input[0]);
    let index = 1;
    
    let exam = input[index++];
    let score =Number(input[index++]);

    let gradesSum = 0;
    let numberOfProblems = 0;
    let badGradesCounter = 0;
    let goodGradesCounter = 0;
    let lastExam = "";


    while (exam!=="Enough") {
        gradesSum+=score;
        numberOfProblems++;

        if (score<=4) {
            badGradesCounter++;
            if(badGradesCounter==numberBadGrades){
                console.log(`You need a break, ${badGradesCounter} poor grades.`)
                return;
            }
        }else{
            goodGradesCounter++;
        }

        lastExam = exam;
        exam = input[index++];
        score = Number(input[index++]);
    }


    console.log(`Average score: ${(gradesSum/(badGradesCounter+goodGradesCounter)).toFixed(2)}`);
    console.log(`Number of problems: ${numberOfProblems}`);
    console.log(`Last problem: ${lastExam}`)
}