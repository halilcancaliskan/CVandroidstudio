import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

data class ProfessionalExperience(
    val date: String,
    val title: String,
    val school: String,
    val description: String
)

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun welcomeScreen() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Partie gauche (photo)
        Box(
            modifier = Modifier
                .width(150.dp)
                .fillMaxHeight()
        ) {
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource("profil.jpg"), // Charger l'image "profil.jpg"
                    contentDescription = "Profil Image"
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Permis B",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )

                Text(
                    text = "24 ans",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }


        Spacer(modifier = Modifier.width(16.dp) ) // Espace entre les deux parties

        // Partie droite (Expériences & Formations)
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Halil-Can Caliskan",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Développeur Full-Stack",
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Encadrement de la section "Expérience professionnelle"
            SectionStyle(title = "Expérience professionnelle")

            val experiences = listOf(
                ProfessionalExperience(
                    date = "2023 - 2024",
                    title = "Contrat D'Apprentissage Développeur Full-Stack",
                    school = "Leroy Merlin",
                    description = "Travail en équipe pour développer des applications Java et VueJS."
                ),
                ProfessionalExperience(
                    date = "2022 - 2023",
                    title = "Contrat D'Apprentissage Développeur Back-End",
                    school = "Decathlon",
                    description = "Participation au développement de services back-end en Java."
                )
            )

            for (experience in experiences) {
                ExperienceStyle(
                    date = experience.date,
                    title = experience.title,
                    school = experience.school,
                    description = experience.description
                )
            }

            // Séparation entre les sections
            Divider(modifier = Modifier.padding(vertical = 16.dp))

            // Encadrement de la section "Diplômes & Formations"
            SectionStyle(title = "Diplômes & Formations")

            val educationExperiences = listOf(
                ProfessionalExperience(
                    date = "2023 - 2024",
                    title = "Master 2 Informatique",
                    school = "EFFICOM Lille",
                    description = "Développement d'applications en Java and VueJS."
                ),
                ProfessionalExperience(
                    date = "2022 - 2023",
                    title = "Master 1 Informatique",
                    school = "EFFICOM Lille",
                    description = "Développement d'applications en Java."
                )
            )

            for (experience in educationExperiences) {
                ExperienceStyle(
                    date = experience.date,
                    title = experience.title,
                    school = experience.school,
                    description = experience.description
                )
            }
        }
    }
}

@Composable
fun SectionStyle(title: String) {
    Text(
        text = title,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun ExperienceStyle(date: String, title: String, school: String, description: String) {
    Column(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text(text = date, fontSize = 16.sp)
        Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text(text = school, fontSize = 16.sp)
        Text(text = description, fontSize = 14.sp)
    }
}
