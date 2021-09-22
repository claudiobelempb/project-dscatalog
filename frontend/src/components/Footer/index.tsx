import { Container } from '../Container';
import { Content } from '../Content';
import { FooterContainer } from './styles';

type FooterProps = {
  children: React.ReactNode;
};

const Footer: React.FC<FooterProps> = ({ children }) => {
  return (
    <FooterContainer>
      <Container>
        <Content>{children}</Content>
      </Container>
    </FooterContainer>
  );
};

export { Footer };
