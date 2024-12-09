import React, { useState } from 'react';
import { Button, Form, Dropdown, TextArea, Radio, Checkbox, Message } from 'semantic-ui-react';
import "./FeedbackForm.css";

const FeedbackForm = () => {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    pinCode: '',
    password: '',
    rePassword: '',
    gender: '', // initial gender value is empty
    subjects: [],
    skills: [],
    grade: '',
    feedback: '',
    qualification: '',
    hobbies: '',
    points: 5, // Initial value for points
  });

  const [errors, setErrors] = useState({});
  const [successMessage, setSuccessMessage] = useState('');

  const gradeOptions = [
    { key: 'A', value: 'A', text: 'A' },
    { key: 'B', value: 'B', text: 'B' },
    { key: 'C', value: 'C', text: 'C' },
  ];

  const qualificationOptions = [
    { key: 'High School', value: 'High School', text: 'High School' },
    { key: 'Bachelor', value: 'Bachelor', text: 'Bachelor' },
    { key: 'Master', value: 'Master', text: 'Master' },
  ];

  const handlegenderChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevState) => ({
      ...prevState,
      [name]: value, // Update the state with the name and value of the input
    }));
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleDropdownChange = (e, { name, value }) => {
    setFormData({ ...formData, [name]: value });
  };

  const handleCheckboxChange = (e, { name, value }) => {
    const updatedValues = formData[name].includes(value)
      ? formData[name].filter(item => item !== value)
      : [...formData[name], value];
    setFormData({ ...formData, [name]: updatedValues });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setErrors({});  

    const newErrors = {};

    if (!/^[A-Za-z\s]+$/.test(formData.name)) {
      newErrors.name = 'Name should only contain letters and spaces';
    }

    if (!/^[a-zA-Z0-9._%+-]+@[a-zAZ0-9.-]+\.[a-zA-Z]{2,}$/.test(formData.email)) {
      newErrors.email = 'Please enter a valid email address';
    }

    if (!/^[0-9]{6}$/.test(formData.pinCode)) {
      newErrors.pinCode = 'Please enter a valid PINCODE';
    }

    if (formData.password !== formData.rePassword) {
      newErrors.password = 'Passwords do not match';
    }

    if(!/^[a-zA-Z\s,]+$/.test(formData.hobbies)){
      newErrors.hobbies = 'Please enter hobbies properly';
    }

    if (Object.keys(newErrors).length > 0) {
      setErrors(newErrors);
      return;
    }

    console.log('Form submitted:', formData);
    setSuccessMessage('Form submitted successfully!');

    setFormData({
      name: '',
      email: '',
      pinCode: '',
      password: '',
      rePassword: '',
      gender: '',
      subjects: [],
      skills: [],
      grade: '',
      feedback: '',
      qualification: '',
      hobbies: '',
      points: 5,
    });
  };

  return (
    <div className="form-container">
      <h1 className="form-title">Feedback Form</h1>

      {Object.keys(errors).length > 0 && (
        <Message
          error
          header="There are some errors in your form"
          list={Object.values(errors)}
        />
      )}

      {successMessage && <div className="success-message">{successMessage}</div>}

      <Form onSubmit={handleSubmit} className="feedback-form">
        <Form.Input
          label="Name"
          name="name"
          value={formData.name}
          onChange={handleChange}
          placeholder="Enter your name"
          required
          error={errors.name ? { content: errors.name, pointing: 'below' } : null}
        />
        <Form.Input
          label="Email"
          name="email"
          value={formData.email}
          onChange={handleChange}
          placeholder="Enter your email"
          required
          error={errors.email ? { content: errors.email, pointing: 'below' } : null}
        />
        <Form.Input
          label="Pin Code"
          name="pinCode"
          value={formData.pinCode}
          onChange={handleChange}
          placeholder="Enter your pin code"
          required
          error={errors.pinCode ? { content: errors.pinCode, pointing: 'below' } : null}
        />
        <Form.Input
          label="Password"
          name="password"
          value={formData.password}
          onChange={handleChange}
          placeholder="Enter your password"
          type="password"
          required
          error={errors.password ? { content: errors.password, pointing: 'below' } : null}
        />
        <Form.Input
          label="Re-enter Password"
          name="rePassword"
          value={formData.rePassword}
          onChange={handleChange}
          placeholder="Re-enter password"
          type="password"
          required
          error={errors.password ? { content: errors.password, pointing: 'below' } : null}
        />
        <div className="gender-section">
          <label>Gender:</label>
          <Form.Field>
            <Radio
              label="Male"
              name="gender"
              value="Male"
              checked={formData.gender === 'Male'}
              onChange={handlegenderChange} // This should update the gender in the state
            />
          </Form.Field>
          <Form.Field>
            <Radio
              label="Female"
              name="gender"
              value="Female"
              checked={formData.gender === 'Female'}
              onChange={handlegenderChange} // This should update the gender in the state
            />
          </Form.Field>
          <Form.Field>
            <Radio
              label="Other"
              name="gender"
              value="Other"
              checked={formData.gender === 'Other'}
              onChange={handlegenderChange} // This should update the gender in the state
            />
          </Form.Field>
        </div>
        <div className="subjects-section">
          <label>Subjects:</label>
          {['Math', 'Science', 'History'].map(subject => (
            <Form.Field key={subject}>
              <Checkbox
                label={subject}
                name="subjects"
                value={subject}
                checked={formData.subjects.includes(subject)}
                onChange={handleCheckboxChange}
              />
            </Form.Field>
          ))}
        </div>
        <div className="skills-section">
          <label>Skills:</label>
          {['Programming', 'Communication', 'Problem-Solving'].map(skill => (
            <Form.Field key={skill}>
              <Checkbox
                label={skill}
                name="skills"
                value={skill}
                checked={formData.skills.includes(skill)}
                onChange={handleCheckboxChange}
              />
            </Form.Field>
          ))}
        </div>
        <Form.Dropdown
          label="Grade"
          name="grade"
          options={gradeOptions}
          value={formData.grade}
          onChange={handleDropdownChange}
          selection
          required
          error={errors.grade ? { content: errors.grade, pointing: 'below' } : null}
        />
        <TextArea
          label="Feedback"
          name="feedback"
          value={formData.feedback}
          onChange={handleChange}
          placeholder="Enter your feedback"
          required
        />
        <Form.Dropdown
          label="Qualification"
          name="qualification"
          options={qualificationOptions}
          value={formData.qualification}
          onChange={handleDropdownChange}
          selection
          required
        />
        <Form.Input
          label="Hobbies"
          name="hobbies"
          value={formData.hobbies}
          onChange={handleChange}
          placeholder="e.g., Painting, Reading"
          required
        />

        <label>Points:</label>
        <input
          type="range"
          id="points"
          name="points"
          min="0"
          max="10"
          value={formData.points}
          onChange={handleChange}
        />
        <span>{formData.points}</span>

        <Button type="submit" primary>
          Submit
        </Button>
      </Form>
    </div>
  );
};

export default FeedbackForm;
