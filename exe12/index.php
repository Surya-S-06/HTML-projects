<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Books List</title>
</head>
<body>

<?php

$xml = simplexml_load_file("books.xml");
if ($xml === false) {
    echo "<p>Error: Unable to load XML file.</p>";
} else {
    echo "<h2>Books List</h2>";
    echo "<table border='1' cellpadding='10' cellspacing='0'>";
    echo "<tr>";
    echo "<th>Title</th>";
    echo "<th>Author</th>";
    echo "<th>Year</th>";
    echo "<th>Price</th>";
    echo "</tr>";
    foreach ($xml->book as $book) {
        echo "<tr>";
        echo "<td>" . htmlspecialchars($book->title) . "</td>";
        echo "<td>" . htmlspecialchars($book->author) . "</td>";
        echo "<td>" . htmlspecialchars($book->year) . "</td>";
        echo "<td>" . htmlspecialchars($book->price) . "</td>";
        echo "</tr>";
    }
    echo "</table>";
}
?>
</body>
</html>
