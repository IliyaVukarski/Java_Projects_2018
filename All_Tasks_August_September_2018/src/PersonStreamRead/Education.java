package PersonStreamRead;
/**
 * 
 * @author Iliya Vukarski
 *
 */
import java.time.LocalDate;

public class Education {
	private String degree;
	private final String institutionName;
	private final LocalDate enrollmentDate;
	private LocalDate graduationDate;
	
	public Education(String degree, String institutionName,
			LocalDate enrollmentDate, LocalDate graduationDate) {
		super();
		this.degree = degree;
		this.institutionName = institutionName;
		this.enrollmentDate = enrollmentDate;
		this.graduationDate = graduationDate;
	}
	
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public LocalDate getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(LocalDate graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}
}
