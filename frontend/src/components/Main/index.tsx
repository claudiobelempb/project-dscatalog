import { Container } from '../Container';
import { Content } from '../Content';
import { MainContainer } from './styles';

type MainProps = {
  children: React.ReactNode;
};
const Main: React.FC<MainProps> = ({ children }) => {
  return (
    <MainContainer>
      <Container>
        <Content>{children}</Content>
      </Container>
    </MainContainer>
  );
};

export { Main };
