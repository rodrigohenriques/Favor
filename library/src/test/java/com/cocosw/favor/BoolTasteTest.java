package com.cocosw.favor;

import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Mohd Farid mohd.farid@devfactory.com @link <a href="https://github.com/mfarid">mfarid</a>
 */
public class BoolTasteTest {

    private SharedPreferences sharedPreferences;

    private final String[] defaultValues = {"true", "false"};

    private SharedPreferences.Editor editor;

    private Taste.BoolTaste BoolTaste;

    @Before
    public void setup() {
        sharedPreferences = Mockito.mock(SharedPreferences.class);
        Mockito.when(sharedPreferences.getBoolean("key", true)).thenReturn(true);
        editor = Mockito.mock(SharedPreferences.Editor.class);
        BoolTaste = new Taste.BoolTaste(sharedPreferences, "key", defaultValues);
    }

    @Test
    public void testGet() throws Exception {
        //when
        Object getResult = BoolTaste.get();

        //then
        assertEquals("get() must return true as configured in sharedPreferences", true, getResult);
    }

    @Test
    public void testEditor() throws Exception {
        //given
        Mockito.when(sharedPreferences.edit()).thenReturn(editor);

        //when
        BoolTaste.editor(true);

        //then
        Mockito.verify(editor).putBoolean("key", true);
    }
}