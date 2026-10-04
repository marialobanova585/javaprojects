public class ComplexMatrix{
    public int rows;
    public int cols;
    public Complex[][] data;
    public ComplexMatrix(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.data = new Complex[rows][cols];
        for (int i = 0; i<rows;i++){
            for(int j = 0; j<cols; j++){
                this.data[i][j] = new Complex(0, 0);
            }
        }

    }
    public ComplexMatrix add(ComplexMatrix other){
        if(this.rows!= other.rows || this.cols!= other.cols){
            System.out.println("Размеры матриц должны быть одинаковыми");
            return null;
        }
        ComplexMatrix result = new ComplexMatrix(rows, cols);
        for (int i = 0; i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j].add(other.data[i][j]);
            }
        }
        return result;
    }
     public ComplexMatrix multiply(ComplexMatrix other) {
         if (this.rows != other.cols) {
             System.out.println("Ошибка:строки должны совпадать со столбцами");
             return null;
         }

         ComplexMatrix result = new ComplexMatrix(rows, cols);
         for (int i = 0; i<rows;i++) {
             for (int j = 0; j < cols; j++) {
                 Complex sum = new Complex(0,0);
                 for(int k = 0;k<this.cols;k++){
                     Complex obj = this.data[i][k].multiply(other.data[k][j]);
                     sum = sum.add(obj);
                 }
                 result.data[i][j] = sum;

                 }
             }
         return result;
     }
     public ComplexMatrix transpose(){
        ComplexMatrix result = new ComplexMatrix(rows, cols);
        for( int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                result.data[j][i]=this.data[i][j];
            }
        }
        return result;
    }
    public ComplexMatrix Minor(int cutRow, int cutCol){
        ComplexMatrix minor=new ComplexMatrix(this.rows-1,this.cols-1);
        int r=0;
        for(int i=0;i<this.rows;i++){
            if(i==cutRow){
                continue;
            }
            int c=0;
            for(int j=0;j<this.cols;j++){
                if(j==cutCol){
                    continue;
                }
                minor.data[r][c]=this.data[i][j];
                c++;
            }
            r++;
        }
        return minor;
    }
    public Complex determinate() {
        if (this.rows != this.cols) {
            System.out.println("Матрицы должны быть квадртаными!");
            return null;
        }
        if (this.rows == 1) {
            return this.data[0][0];
        }
        Complex resultDeterminate = new Complex(0, 0);
        for (int j = 0; j < this.cols; j++) {
            ComplexMatrix minor = this.Minor(0, j);
            Complex minorDeterminate = minor.determinate();
            Complex object = this.data[0][j];
            Complex result = object.multiply(minorDeterminate);
            if (j % 2 == 0) {
                resultDeterminate = resultDeterminate.add(result);
            } else {
                resultDeterminate = resultDeterminate.subtract(result);
            }
        }
        return resultDeterminate;
    }
    public ComplexMatrix reverse(){
        Complex determinate=this.determinate();
        if(determinate.real==0 && determinate.imag==0){
            System.out.println("Определитель не должен равняться нулю");
            return null;
        }
        ComplexMatrix reverse=new ComplexMatrix(this.rows,this.cols);
        if(this.rows==1){
            Complex revDeterminate=new Complex(1,0).divide(determinate);
            reverse.data[0][0]=revDeterminate;
            return reverse;
        }
        ComplexMatrix additional=new ComplexMatrix(this.rows, this.cols);
         for(int i=0;i<this.rows;i++){
             for(int j=0;j<this.cols;j++){
                 ComplexMatrix minor = this.Minor(i,j);
                 Complex minorDeterminate = minor.determinate();
                  if((i+j)%2!=0){
                      minorDeterminate=minorDeterminate.multiply(new Complex(-1,0));
                  }
                  additional.data[i][j]=minorDeterminate;
             }
         }
         ComplexMatrix additionalTranspose=additional.transpose();
         Complex revDeterminate=new Complex(1,0).divide(determinate);
         for(int i=0;i<this.rows;i++){
             for(int j=0;j<this.cols;j++){
                 reverse.data[i][j]=additionalTranspose.data[i][j].multiply(revDeterminate);
             }
         }
         return reverse;

    }
    public ComplexMatrix divide(ComplexMatrix other){
        if(this.cols!= other.rows || other.rows!= other.cols){
            System.out.println("Деление не получится из за неправильныз размеров матриц");
            return null;
        }
        ComplexMatrix  reverseMatrix=other.reverse();
        if(reverseMatrix==null){
            return null;
        }
        return this.multiply(reverseMatrix);
    }
    public void print(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }
    }
}