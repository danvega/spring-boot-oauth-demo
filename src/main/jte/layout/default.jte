@import org.springframework.security.web.csrf.CsrfToken

@param gg.jte.Content content
@param CsrfToken csrf = null

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Spring Security Demo</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
${content}
</body>
</html>