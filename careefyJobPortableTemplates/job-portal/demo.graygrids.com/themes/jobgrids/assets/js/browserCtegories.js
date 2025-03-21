// Function to fetch job categories and display them
function loadJobCategories() {
    fetch('http://localhost:8090/jobType/getAll')
        .then(response => response.json())
        .then(jobCategories => {
            const cardsContainer = document.getElementById('jobCategoryCards');
            cardsContainer.innerHTML = ''; // Clear any existing cards

            // Icon mapping for different job categories
            const iconMap = {
                'Technical Support': 'lni-cog',
                'Business Development': 'lni-layers',
                'Real Estate Business': 'lni-home',
                'Share Market Analysis': 'lni-search',
                'Finance & Banking Service': 'lni-investment',
                'IT & Networking Services': 'lni-cloud-network',
                'Restaurant Services': 'lni-restaurant',
                'Defence & Fire Service': 'lni-fireworks',
                // Add more categories here as needed
            };

            jobCategories.forEach(category => {
                const card = document.createElement('div');
                card.classList.add('col-lg-3', 'col-md-6', 'col-12');
                card.classList.add('wow', 'fadeInUp');
                card.setAttribute('data-wow-delay', '.2s');

                // Use the iconMap to get the icon for each category
                const iconClass = iconMap[category.name] || 'lni-default'; // Default if no mapping

                card.innerHTML = `
                        <a href="browse-jobs.html" class="single-cat">
                            <div class="icon">
                                <i class="lni ${iconClass}"></i>
                            </div>
                            <h3>${category.name}</h3>
                        </a>
                    `;

                cardsContainer.appendChild(card);
            });
        })
        .catch(error => console.error('Error loading job categories:', error));
}

// Load job categories when the page is loaded
window.onload = loadJobCategories;
