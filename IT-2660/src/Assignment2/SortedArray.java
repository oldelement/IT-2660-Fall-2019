package Assignment2;

public class SortedArray {
    int max, counter;
    StudentListings[] students;

    public SortedArray(int maximumSize) {
        max = maximumSize;
        students = new StudentListings[0];
    }

    public StudentListings[] sortArray(StudentListings  x [ ] )        //had a lot of trouble with this, had to look for help online.
    {                                                                  
        int j;
        boolean flag = true;
        StudentListings temp;

        while ( flag )
        {
            flag = false;
            for ( j = 0;  j < x.length - 1;  j++ )
            {
                if ( x [ j ].name.compareToIgnoreCase( x [ j+1 ].name ) > 0 )
                {
                    temp = x [ j ];
                    x [ j ] = x [ j+1];
                    x [ j+1] = temp;
                    flag = true;
                }
            }
        }
        return x;
    }

    public boolean insert(StudentListings newNode) {
        boolean nodeInsert = false;
        StudentListings[] newArray = new StudentListings[students.length + 1];
        if (newArray.length > max) {
            return false;
        }
        counter = 0;
        if (students.length == 0) {
            newArray[counter] = newNode;
        }

            for (StudentListings student : students) {
                newArray[counter] = student;
                counter++;
                if (nodeInsert == false) {
                    newArray[counter] = newNode;
                    nodeInsert = true;
                    counter++;
                }
        }
        students = newArray;
        return true;
    }

    public StudentListings fetch(String targetKey) {
        for (int i = 0; i < students.length; i++) {
            if (targetKey.equals(students[i].name)) {
                return students[i];
            }
        }
        return new StudentListings();
    }

    public boolean delete(String targetKey) {
        boolean nodeDeleted = false;
        StudentListings[] newArray = new StudentListings[students.length - 1];
        counter = 0;
        int newCounter = 0;

        for (StudentListings student : students) {

            if (student.name.equals(targetKey)) {
                nodeDeleted = true;
                newCounter++;
            }
            
            if (nodeDeleted == false && counter < students.length-1) {
                newArray[counter] = students[newCounter];
                counter++;
                newCounter++;
            }
            nodeDeleted = false;
        }
            students = newArray;
            return true;
        }

    public boolean update(String targetKey, StudentListings newNode) {
        delete(targetKey);
        insert(newNode);
        return true;
    }


}