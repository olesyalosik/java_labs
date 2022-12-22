//Лосик Олеси, 7группа
package com.company;

import java.io.IOException;
import java.io.Serializable;

public interface DealsInterface extends Serializable {

    void read(String path_1,String path_2) throws IOException;
    void write(String path_1,String path_2) throws IOException;
    void serialization() throws IOException;
    void deserialization() throws IOException, ClassNotFoundException;
    void search();
    void add(int param);
    void delete(int param);
    void update(int param);
}