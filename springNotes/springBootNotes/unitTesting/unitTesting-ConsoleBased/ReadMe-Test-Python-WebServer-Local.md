# Testing Bootstrap Page with Python's Built-in HTTP Server

## Prerequisites

Before you begin, ensure you have:
* Python 3.x installed on your system
* A modern web browser (Chrome, Firefox, Safari, or Edge)
* The Bootstrap page files in your working directory

## Starting the Server

1. Open your terminal or command prompt
2. Navigate to the directory containing your web files
3. Run the following command:

```bash
python3 -m http.server 8000
```

You should see output similar to:
```
Serving HTTP on 0.0.0.0 port 8000 (http://0.0.0.0:8000/) ...
```

## Accessing the Page

Once the server is running:
1. Open your web browser
2. Navigate to either:
* `http://localhost:8000`
* `http://127.0.0.1:8000`

## Testing Checklist

### Navigation Components
* [ ] Verify all navigation tabs work:
* Overview
* Fundamentals
* Best Practices
* Examples
* Program
* Output
* [ ] Check if the navigation collapses into a hamburger menu on mobile view
* [ ] Ensure all Bootstrap icons are visible in the navigation

### Carousel
* [ ] Test auto-rotation functionality
* [ ] Verify manual navigation (next/previous buttons)
* [ ] Ensure all three slides display correctly
* [ ] Check if slide indicators work

### Content
* [ ] Verify content loads in each tab
* [ ] Check if code snippets have proper syntax highlighting
* [ ] Ensure the hero section (jumbotron-style) is properly centered
* [ ] Verify all images load correctly

### Responsive Design
* [ ] Test page at different window sizes
* [ ] Verify content reflows appropriately on mobile devices
* [ ] Check that text remains readable at all sizes
* [ ] Ensure buttons and interactive elements are properly sized for touch devices

## Cross-Browser Testing

Test the page in multiple browsers:
1. **Desktop Browsers**
* Google Chrome
* Mozilla Firefox
* Safari (macOS)
* Microsoft Edge

2. **Mobile Testing**
* Use browser developer tools (F12) to simulate different devices
* Test on actual mobile devices when possible
* Verify touch interactions work correctly

## Troubleshooting Tips

### Common Issues and Solutions

1. **Server Won't Start**
* Check if port 8000 is already in use
* Try a different port: `python3 -m http.server 8001`
* Ensure you have necessary permissions

2. **Page Not Loading**
* Verify the server is running
* Check browser console for errors (F12)
* Clear browser cache and refresh

3. **Broken Styles/Scripts**
* Ensure internet connection (for CDN resources)
* Verify all file paths are correct
* Check browser console for 404 errors

4. **Mobile Display Issues**
* Clear browser cache
* Try different mobile devices/emulators
* Verify viewport meta tag is present

### Stopping the Server

To stop the server:
* Press `Ctrl + C` in the terminal
* Close the terminal window

### Making Changes

1. Stop the server
2. Edit your files
3. Restart the server
4. Refresh your browser

## Additional Notes

* The server does not automatically reload when files change
* For development, consider using tools like `live-server` for auto-reload functionality
* Keep the terminal window open while testing
* Monitor the terminal for any error messages or access logs

