package com.newyeargift.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.newyeargift.model.sweet.Sweet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SweetFileReaderTest {

    private static final String FIRST_LINE = "COOKIE;First;10;30;true";
    private static final String SECOND_LINE = "COOKIE;Second;15;40;false";

    @Mock
    private SweetCreator sweetCreator;

    @Mock
    private Sweet firstSweet;

    @Mock
    private Sweet secondSweet;

    private SweetFileReader reader;

    @BeforeEach
    void setUp() {
        reader = new SweetFileReader(sweetCreator);
    }

    @Test
    void readSweets_createsSweetForEveryDataLine() throws IOException {
        when(sweetCreator.createSweet(FIRST_LINE)).thenReturn(firstSweet);
        when(sweetCreator.createSweet(SECOND_LINE)).thenReturn(secondSweet);

        List<Sweet> sweets = reader.readSweets(
                toStream(FIRST_LINE, SECOND_LINE));

        assertEquals(List.of(firstSweet, secondSweet), sweets);
    }

    @Test
    void readSweets_skipsCommentsAndBlankLines() throws IOException {
        when(sweetCreator.createSweet(FIRST_LINE)).thenReturn(firstSweet);

        List<Sweet> sweets = reader.readSweets(
                toStream("# just a comment", "", "   ", FIRST_LINE));

        assertEquals(List.of(firstSweet), sweets);
        verify(sweetCreator, never()).createSweet("# just a comment");
    }

    @Test
    void readSweets_returnsEmptyListForEmptyFile() throws IOException {
        List<Sweet> sweets = reader.readSweets(toStream());

        assertTrue(sweets.isEmpty());
    }

    private InputStream toStream(String... lines) {
        String content = String.join("\n", lines);
        return new ByteArrayInputStream(
                content.getBytes(StandardCharsets.UTF_8));
    }
}