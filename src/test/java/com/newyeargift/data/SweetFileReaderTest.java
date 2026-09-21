package com.newyeargift.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.newyeargift.model.sweet.Sweet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SweetFileReaderTest {

    private static final String FIRST_LINE = "COOKIE;First;10;30;true";
    private static final String SECOND_LINE = "COOKIE;Second;15;40;false";

    @TempDir
    Path tempDir;

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
        Path file = writeFile(FIRST_LINE, SECOND_LINE);

        List<Sweet> sweets = reader.readSweets(file);

        assertEquals(List.of(firstSweet, secondSweet), sweets);
    }

    @Test
    void readSweets_skipsCommentsAndBlankLines() throws IOException {
        when(sweetCreator.createSweet(FIRST_LINE)).thenReturn(firstSweet);
        Path file = writeFile("# just a comment", "", "   ", FIRST_LINE);

        List<Sweet> sweets = reader.readSweets(file);

        assertEquals(List.of(firstSweet), sweets);
        verify(sweetCreator, never()).createSweet("# just a comment");
    }

    @Test
    void readSweets_returnsEmptyListForEmptyFile() throws IOException {
        Path file = writeFile();

        List<Sweet> sweets = reader.readSweets(file);

        assertTrue(sweets.isEmpty());
    }

    @Test
    void readSweets_throwsExceptionWhenFileDoesNotExist() {
        Path missingFile = tempDir.resolve("missing.txt");

        assertThrows(IOException.class, () -> reader.readSweets(missingFile));
    }

    private Path writeFile(String... lines) throws IOException {
        return Files.write(tempDir.resolve("sweets.txt"), List.of(lines));
    }
}