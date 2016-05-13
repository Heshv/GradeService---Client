
package gradeservice.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateMark complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateMark"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="subjectId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="studentId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="grade" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateMark", propOrder = {
    "name",
    "subjectId",
    "studentId",
    "grade",
    "id"
})
public class UpdateMark {

    protected String name;
    protected int subjectId;
    protected int studentId;
    protected float grade;
    protected int id;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the subjectId property.
     * 
     */
    public int getSubjectId() {
        return subjectId;
    }

    /**
     * Sets the value of the subjectId property.
     * 
     */
    public void setSubjectId(int value) {
        this.subjectId = value;
    }

    /**
     * Gets the value of the studentId property.
     * 
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Sets the value of the studentId property.
     * 
     */
    public void setStudentId(int value) {
        this.studentId = value;
    }

    /**
     * Gets the value of the grade property.
     * 
     */
    public float getGrade() {
        return grade;
    }

    /**
     * Sets the value of the grade property.
     * 
     */
    public void setGrade(float value) {
        this.grade = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

}
